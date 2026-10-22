package com.android.server.power.stats.processor;

import android.util.Slog;
import com.android.internal.os.LongArrayMultiStateCounter;
import com.android.internal.util.Preconditions;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.util.Arrays;
import java.util.function.Consumer;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes3.dex */
class MultiStateStats {
    public static final int STATE_DOES_NOT_EXIST = -1;
    private static final String TAG = "MultiStateStats";
    private static final String XML_TAG_STATS = "stats";
    private int mCompositeState;
    private final LongArrayMultiStateCounter mCounter;
    private final Factory mFactory;
    private boolean mTracking;

    static class Factory {
        private static final int INVALID_SERIAL_STATE = -1;
        final int[] mCompositeToSerialState;
        final int mDimensionCount;
        final int mSerialStateCount;
        private final int[] mStateBitFieldMasks;
        private final short[] mStateBitFieldShifts;
        final States[] mStates;

        Factory(int dimensionCount, States... states) {
            this.mDimensionCount = dimensionCount;
            this.mStates = states;
            int serialStateCount = 1;
            States[] r1 = this.mStates;
            int r2 = r1.length;
            int r3 = 0;
        L3:
            if (r3 >= r2) goto L8;
            States state = r1[r3];
            if (state.mTracked == false) goto L7;
            serialStateCount = serialStateCount * state.mLabels.length;
        L7:
            r3 = r3 + 1;
            goto L3
        L8:
            this.mSerialStateCount = serialStateCount;
            this.mStateBitFieldMasks = new int[this.mStates.length];
            this.mStateBitFieldShifts = new short[this.mStates.length];
            int shift = 0;
            int i = 0;
        L10:
            if (i >= this.mStates.length) goto L17;
            this.mStateBitFieldShifts[i] = (short) shift;
            if (this.mStates[i].mLabels.length < 2) goto L15;
            int max = this.mStates[i].mLabels.length - 1;
            int bitcount = 32 - Integer.numberOfLeadingZeros(max);
            this.mStateBitFieldMasks[i] = ((1 << bitcount) - 1) << shift;
            shift = shift + bitcount;
            i = i + 1;
            goto L10
        L15:
            throw new IllegalArgumentException("Invalid state: " + Arrays.toString(this.mStates[i].mLabels) + ". Should have at least two values.");
        L17:
            if (shift >= 31) goto L39;
            int trackedMask = -1;
            int state2 = 0;
        L20:
            if (state2 >= this.mStates.length) goto L25;
            if (this.mStates[state2].mTracked == true) goto L24;
            trackedMask = trackedMask & (~this.mStateBitFieldMasks[state2]);
        L24:
            state2 = state2 + 1;
            goto L20
        L25:
            int state3 = 1 << shift;
            this.mCompositeToSerialState = new int[state3];
            Arrays.fill(this.mCompositeToSerialState, -1);
            int nextSerialState = 0;
            int composite = 0;
        L27:
            if (composite >= this.mCompositeToSerialState.length) goto L37;
            if (isValidCompositeState(composite) == false) goto L35;
            int baseComposite = composite & trackedMask;
            if (this.mCompositeToSerialState[baseComposite] == (-1)) goto L34;
            this.mCompositeToSerialState[composite] = this.mCompositeToSerialState[baseComposite];
            goto L35
        L34:
            this.mCompositeToSerialState[composite] = nextSerialState;
            nextSerialState = nextSerialState + 1;
        L35:
            composite = composite + 1;
            goto L27
        L37:
            return;
        L39:
            throw new IllegalArgumentException("Too many states: " + shift + " bits are required to represent the composite state, but only 31 are available");
        }

        private boolean isValidCompositeState(int composite) {
            int stateIndex = 0;
        L4:
            if (stateIndex >= this.mStates.length) goto L10;
            int state = extractStateFromComposite(composite, stateIndex);
            if (state >= this.mStates[stateIndex].mLabels.length) goto L7;
            stateIndex = stateIndex + 1;
            goto L4
        L7:
            return false;
        L10:
            return true;
        }

        private int extractStateFromComposite(int compositeState, int stateIndex) {
            return (this.mStateBitFieldMasks[stateIndex] & compositeState) >>> this.mStateBitFieldShifts[stateIndex];
        }

        int setStateInComposite(int baseCompositeState, int stateIndex, int value) {
            return ((~this.mStateBitFieldMasks[stateIndex]) & baseCompositeState) | (value << this.mStateBitFieldShifts[stateIndex]);
        }

        int setStateInComposite(int compositeState, String stateName, String stateLabel) {
            int stateIndex = 0;
        L4:
            if (stateIndex >= this.mStates.length) goto L18;
            States stateConfig = this.mStates[stateIndex];
            if (stateConfig.mName.equals(stateName) == true) goto L7;
            stateIndex = stateIndex + 1;
            goto L4
        L7:
            int state = 0;
        L9:
            if (state >= stateConfig.mLabels.length) goto L15;
            if (stateConfig.mLabels[state].equals(stateLabel) == true) goto L13;
            state = state + 1;
            goto L9
        L13:
            return setStateInComposite(compositeState, stateIndex, state);
        L15:
            Slog.e(MultiStateStats.TAG, "Unexpected label '" + stateLabel + "' for state: " + stateName);
            return -1;
        L18:
            Slog.e(MultiStateStats.TAG, "Unsupported state: " + stateName);
            return -1;
        }

        MultiStateStats create() {
            return new MultiStateStats(this, this.mDimensionCount);
        }

        public int getSerialStateCount() {
            return this.mSerialStateCount;
        }

        public int getSerialState(int[] states) {
            if (states.length != this.mStates.length) goto L5;
            boolean r0 = true;
        L6:
            Preconditions.checkArgument(r0);
            int compositeState = 0;
            int i = 0;
        L8:
            if (i >= states.length) goto L10;
            compositeState = setStateInComposite(compositeState, i, states[i]);
            i = i + 1;
            goto L8
        L10:
            int serialState = this.mCompositeToSerialState[compositeState];
            if (serialState == (-1)) goto L14;
            return serialState;
        L14:
            throw new IllegalArgumentException("State values out of bounds: " + Arrays.toString(states));
        L5:
            r0 = false;
            goto L6
        }

        int getSerialState(int compositeState) {
            return this.mCompositeToSerialState[compositeState];
        }
    }

    static class States {
        final String[] mLabels;
        final String mName;
        final boolean mTracked;

        States(String name, boolean tracked, String... labels) {
            this.mName = name;
            this.mTracked = tracked;
            this.mLabels = labels;
        }

        public boolean isTracked() {
            return this.mTracked;
        }

        public String getName() {
            return this.mName;
        }

        public String[] getLabels() {
            return this.mLabels;
        }

        public static int findTrackedStateByName(States[] states, String name) {
            int i = 0;
        L4:
            if (i >= states.length) goto L9;
            if (states[i].getName().equals(name) == true) goto L7;
            i = i + 1;
            goto L4
        L7:
            return i;
        L9:
            return -1;
        }

        public static void forEachTrackedStateCombination(States[] states, Consumer<int[]> consumer) {
            forEachTrackedStateCombination(consumer, states, new int[states.length], 0);
        }

        private static void forEachTrackedStateCombination(Consumer<int[]> consumer, States[] states, int[] statesValues, int stateIndex) {
            if (stateIndex < statesValues.length) goto L5;
            consumer.accept(statesValues);
            return;
        L5:
            if (states[stateIndex].mTracked == true) goto L8;
            forEachTrackedStateCombination(consumer, states, statesValues, stateIndex + 1);
            return;
        L8:
            int i = 0;
        L10:
            if (i >= states[stateIndex].mLabels.length) goto L13;
            statesValues[stateIndex] = i;
            forEachTrackedStateCombination(consumer, states, statesValues, stateIndex + 1);
            i = i + 1;
            goto L10
        }
    }

    public static /* synthetic */ void $r8$lambda$ezqcON2RlS29qz6G0aLoYDQdE4w(MultiStateStats r0, long[] r1, StringBuilder r2, int[] r3) {
        r0.lambda$toString$1(r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$gWef6G71JOA5KJFbpTLqAAxSIc4(MultiStateStats r0, TypedXmlSerializer r1, long[] r2, int[] r3) {
        r0.lambda$writeXml$0(r1, r2, r3);
    }

    MultiStateStats(Factory factory, int dimensionCount) {
        this.mFactory = factory;
        this.mCounter = new LongArrayMultiStateCounter(factory.mSerialStateCount, dimensionCount);
    }

    int getDimensionCount() {
        return this.mFactory.mDimensionCount;
    }

    States[] getStates() {
        return this.mFactory.mStates;
    }

    void copyStatesFrom(MultiStateStats otherStats) {
        this.mCounter.copyStatesFrom(otherStats.mCounter);
    }

    void setState(int stateIndex, int state, long timestampMs) {
        if (this.mTracking == true) goto L5;
        this.mCounter.updateValues(new long[this.mCounter.getArrayLength()], timestampMs);
        this.mTracking = true;
    L5:
        this.mCompositeState = this.mFactory.setStateInComposite(this.mCompositeState, stateIndex, state);
        this.mCounter.setState(this.mFactory.mCompositeToSerialState[this.mCompositeState], timestampMs);
    }

    void increment(long[] values, long timestampMs) {
        this.mCounter.incrementValues(values, timestampMs);
        this.mTracking = true;
    }

    boolean getStats(long[] outValues, int[] states) {
        return this.mCounter.getCounts(outValues, this.mFactory.getSerialState(states));
    }

    void setStats(int[] states, long[] values) {
        this.mCounter.setValues(this.mFactory.getSerialState(states), values);
    }

    void reset() {
        this.mCounter.reset();
        this.mTracking = false;
    }

    void writeXml(final TypedXmlSerializer serializer) throws IOException {
        final long[] tmpArray = new long[this.mCounter.getArrayLength()];
        States.forEachTrackedStateCombination(this.mFactory.mStates, new MultiStateStats$$ExternalSyntheticLambda1(this, serializer, tmpArray));     // Catch: RuntimeException -> L5
        return;
    L5:
        e = move-exception;
        if ((e.getCause() instanceof IOException) == true) goto L9;
        throw e;
    L9:
        throw ((IOException) e.getCause());
    }

    private /* synthetic */ void lambda$writeXml$0(TypedXmlSerializer serializer, long[] tmpArray, int[] states) {
        writeXmlForStates(serializer, states, tmpArray);     // Catch: IOException -> L4
        return;
    L4:
        e = move-exception;
        throw new RuntimeException(e);
    }

    private void writeXmlForStates(TypedXmlSerializer serializer, int[] states, long[] values) throws IOException {
        if (this.mCounter.getCounts(values, this.mFactory.getSerialState(states)) == true) goto L5;
        return;
    L5:
        serializer.startTag(null, XML_TAG_STATS);
        int i = 0;
    L7:
        if (i >= states.length) goto L14;
        if (this.mFactory.mStates[i].mTracked == false) goto L13;
        if (states[i] == 0) goto L13;
        serializer.attribute(null, this.mFactory.mStates[i].mName, this.mFactory.mStates[i].mLabels[states[i]]);
    L13:
        i = i + 1;
        goto L7
    L14:
        int i2 = 0;
    L16:
        if (i2 >= values.length) goto L21;
        if (values[i2] == 0) goto L20;
        serializer.attributeLong(null, "_" + i2, values[i2]);
    L20:
        i2 = i2 + 1;
        goto L16
    L21:
        serializer.endTag(null, XML_TAG_STATS);
    }

    boolean readFromXml(TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        String outerTag = parser.getName();
        long[] tmpArray = new long[this.mCounter.getArrayLength()];
        int eventType = parser.getEventType();
    L4:
        if (eventType == 1) goto L34;
        if (eventType != 3) goto L10;
        if (parser.getName().equals(outerTag) == true) goto L34;
    L10:
        if (eventType != 2) goto L33;
        if (parser.getName().equals(XML_TAG_STATS) == false) goto L33;
        Arrays.fill(tmpArray, 0);
        int compositeState = 0;
        int attributeCount = parser.getAttributeCount();
        int i = 0;
    L14:
        if (i >= attributeCount) goto L32;
        String attributeName = parser.getAttributeName(i);
        if (attributeName.startsWith("_") == true) goto L35;
        String attributeValue = parser.getAttributeValue(i);
        compositeState = this.mFactory.setStateInComposite(compositeState, attributeName, attributeValue);
        if (compositeState != (-1)) goto L31;
        return false;
    L31:
        i = i + 1;
        goto L14
    L35:
        int index = Integer.parseInt(attributeName.substring(1));     // Catch: NumberFormatException -> L25
        if (index < 0) goto L23;
        if (index >= tmpArray.length) goto L23;
        tmpArray[index] = parser.getAttributeLong(i);
    L23:
        Slog.e(TAG, "State index out of bounds: " + index + " length: " + tmpArray.length);
        return false;
    L25:
        e = move-exception;
        throw new XmlPullParserException("Unexpected index syntax: " + attributeName, parser, e);
    L32:
        this.mCounter.setValues(this.mFactory.getSerialState(compositeState), tmpArray);
    L33:
        eventType = parser.next();
    L34:
        return true;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder();
        final long[] values = new long[this.mCounter.getArrayLength()];
        States.forEachTrackedStateCombination(this.mFactory.mStates, new MultiStateStats$$ExternalSyntheticLambda0(this, values, sb));
        return sb.toString();
    }

    private /* synthetic */ void lambda$toString$1(long[] values, StringBuilder sb, int[] states) {
        if (this.mCounter.getCounts(values, this.mFactory.getSerialState(states)) == true) goto L6;
        return;
    L6:
        if (sb.isEmpty() == true) goto L8;
        sb.append("\n");
    L8:
        sb.append("(");
        boolean first = true;
        int i = 0;
    L10:
        if (i >= states.length) goto L17;
        if (this.mFactory.mStates[i].mTracked == false) goto L16;
        if (first == true) goto L15;
        sb.append(" ");
    L15:
        first = false;
        sb.append(this.mFactory.mStates[i].mLabels[states[i]]);
    L16:
        i = i + 1;
        goto L10
    L17:
        sb.append(") ");
        sb.append(Arrays.toString(values));
    }
}
