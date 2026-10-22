package org.apache.commons.math.util;

import java.io.Serializable;
import java.util.Arrays;
import org.apache.commons.math.MathRuntimeException;
import org.apache.commons.math.exception.util.LocalizedFormats;

/* JADX INFO: loaded from: classes3.dex */
public class ResizableDoubleArray implements DoubleArray, Serializable {
    public static final int ADDITIVE_MODE = 1;
    public static final int MULTIPLICATIVE_MODE = 0;
    private static final long serialVersionUID = -3485529955529426875L;
    protected float contractionCriteria;
    protected float expansionFactor;
    protected int expansionMode;
    protected int initialCapacity;
    protected double[] internalArray;
    protected int numElements;
    protected int startIndex;

    public ResizableDoubleArray() {
        this.contractionCriteria = 2.5f;
        this.expansionFactor = 2.0f;
        this.expansionMode = 0;
        this.initialCapacity = 16;
        this.numElements = 0;
        this.startIndex = 0;
        this.internalArray = new double[this.initialCapacity];
    }

    public ResizableDoubleArray(int initialCapacity) {
        this.contractionCriteria = 2.5f;
        this.expansionFactor = 2.0f;
        this.expansionMode = 0;
        this.initialCapacity = 16;
        this.numElements = 0;
        this.startIndex = 0;
        setInitialCapacity(initialCapacity);
        this.internalArray = new double[this.initialCapacity];
    }

    public ResizableDoubleArray(double[] initialArray) {
        this.contractionCriteria = 2.5f;
        this.expansionFactor = 2.0f;
        this.expansionMode = 0;
        this.initialCapacity = 16;
        this.numElements = 0;
        this.startIndex = 0;
        if (initialArray != null) goto L5;
        this.internalArray = new double[this.initialCapacity];
        return;
    L5:
        this.internalArray = new double[initialArray.length];
        System.arraycopy(initialArray, 0, this.internalArray, 0, initialArray.length);
        this.initialCapacity = initialArray.length;
        this.numElements = initialArray.length;
    }

    public ResizableDoubleArray(int initialCapacity, float expansionFactor) {
        this.contractionCriteria = 2.5f;
        this.expansionFactor = 2.0f;
        this.expansionMode = 0;
        this.initialCapacity = 16;
        this.numElements = 0;
        this.startIndex = 0;
        this.expansionFactor = expansionFactor;
        setInitialCapacity(initialCapacity);
        this.internalArray = new double[initialCapacity];
        setContractionCriteria(0.5f + expansionFactor);
    }

    public ResizableDoubleArray(int initialCapacity, float expansionFactor, float contractionCriteria) {
        this.contractionCriteria = 2.5f;
        this.expansionFactor = 2.0f;
        this.expansionMode = 0;
        this.initialCapacity = 16;
        this.numElements = 0;
        this.startIndex = 0;
        this.expansionFactor = expansionFactor;
        setContractionCriteria(contractionCriteria);
        setInitialCapacity(initialCapacity);
        this.internalArray = new double[initialCapacity];
    }

    public ResizableDoubleArray(int initialCapacity, float expansionFactor, float contractionCriteria, int expansionMode) {
        this.contractionCriteria = 2.5f;
        this.expansionFactor = 2.0f;
        this.expansionMode = 0;
        this.initialCapacity = 16;
        this.numElements = 0;
        this.startIndex = 0;
        this.expansionFactor = expansionFactor;
        setContractionCriteria(contractionCriteria);
        setInitialCapacity(initialCapacity);
        setExpansionMode(expansionMode);
        this.internalArray = new double[initialCapacity];
    }

    public ResizableDoubleArray(ResizableDoubleArray original) {
        this.contractionCriteria = 2.5f;
        this.expansionFactor = 2.0f;
        this.expansionMode = 0;
        this.initialCapacity = 16;
        this.numElements = 0;
        this.startIndex = 0;
        copy(original, this);
    }

    @Override // org.apache.commons.math.util.DoubleArray
    public synchronized void addElement(double value) {
        monitor-enter(this);
        this.numElements++;     // Catch: Throwable -> L6
        if ((this.startIndex + this.numElements) <= this.internalArray.length) goto L8;
        expand();     // Catch: Throwable -> L6
    L8:
        this.internalArray[this.startIndex + (this.numElements - 1)] = value;     // Catch: Throwable -> L6
        if (shouldContract() == false) goto L11;
        contract();     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void addElements(double[] values) {
        monitor-enter(this);
        double[] tempArray = new double[(this.numElements + values.length) + 1];     // Catch: Throwable -> L6
        System.arraycopy(this.internalArray, this.startIndex, tempArray, 0, this.numElements);     // Catch: Throwable -> L6
        System.arraycopy(values, 0, tempArray, this.numElements, values.length);     // Catch: Throwable -> L6
        this.internalArray = tempArray;     // Catch: Throwable -> L6
        this.startIndex = 0;     // Catch: Throwable -> L6
        this.numElements += values.length;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.util.DoubleArray
    public synchronized double addElementRolling(double value) {
        monitor-enter(this);
        double discarded = this.internalArray[this.startIndex];     // Catch: Throwable -> L6
        if ((this.startIndex + (this.numElements + 1)) <= this.internalArray.length) goto L8;
        expand();     // Catch: Throwable -> L6
    L8:
        this.startIndex++;     // Catch: Throwable -> L6
        this.internalArray[this.startIndex + (this.numElements - 1)] = value;     // Catch: Throwable -> L6
        if (shouldContract() == false) goto L11;
        contract();     // Catch: Throwable -> L6
    L11:
        monitor-exit(this);
        return discarded;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized double substituteMostRecentElement(double value) {
        monitor-enter(this);
    L8:
        th = move-exception;
        throw th;
    L4:
        if (this.numElements < 1) goto L11;
        double discarded = this.internalArray[this.startIndex + (this.numElements - 1)];     // Catch: Throwable -> L8
        this.internalArray[this.startIndex + (this.numElements - 1)] = value;     // Catch: Throwable -> L8
        monitor-exit(this);
        return discarded;
    L11:
        throw MathRuntimeException.createArrayIndexOutOfBoundsException(LocalizedFormats.CANNOT_SUBSTITUTE_ELEMENT_FROM_EMPTY_ARRAY, new Object[0]);     // Catch: Throwable -> L8
    }

    protected void checkContractExpand(float contraction, float expansion) {
        if (contraction < expansion) goto L14;
        if (contraction <= 1.0d) goto L12;
        if (expansion <= 1.0d) goto L10;
        return;
    L10:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.EXPANSION_FACTOR_SMALLER_THAN_ONE, new Object[]{Float.valueOf(expansion)});
    L12:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CONTRACTION_CRITERIA_SMALLER_THAN_ONE, new Object[]{Float.valueOf(contraction)});
    L14:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CONTRACTION_CRITERIA_SMALLER_THAN_EXPANSION_FACTOR, new Object[]{Float.valueOf(contraction), Float.valueOf(expansion)});
    }

    @Override // org.apache.commons.math.util.DoubleArray
    public synchronized void clear() {
        monitor-enter(this);
        this.numElements = 0;     // Catch: Throwable -> L7
        this.startIndex = 0;     // Catch: Throwable -> L7
        this.internalArray = new double[this.initialCapacity];     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void contract() {
        monitor-enter(this);
        double[] tempArray = new double[this.numElements + 1];     // Catch: Throwable -> L6
        System.arraycopy(this.internalArray, this.startIndex, tempArray, 0, this.numElements);     // Catch: Throwable -> L6
        this.internalArray = tempArray;     // Catch: Throwable -> L6
        this.startIndex = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized void discardFrontElements(int i) {
        monitor-enter(this);
        discardExtremeElements(i, true);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void discardMostRecentElements(int i) {
        monitor-enter(this);
        discardExtremeElements(i, false);     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized void discardExtremeElements(int i, boolean front) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (i > this.numElements) goto L19;
        if (i < 0) goto L17;
        this.numElements -= i;     // Catch: Throwable -> L9
        if (front == false) goto L12;
        this.startIndex += i;     // Catch: Throwable -> L9
    L12:
        if (shouldContract() == false) goto L14;
        contract();     // Catch: Throwable -> L9
    L14:
        monitor-exit(this);
        return;
    L17:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.CANNOT_DISCARD_NEGATIVE_NUMBER_OF_ELEMENTS, new Object[]{Integer.valueOf(i)});     // Catch: Throwable -> L9
    L19:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.TOO_MANY_ELEMENTS_TO_DISCARD_FROM_ARRAY, new Object[]{Integer.valueOf(i), Integer.valueOf(this.numElements)});     // Catch: Throwable -> L9
    }

    protected synchronized void expand() {
        monitor-enter(this);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.expansionMode != 0) goto L9;
        int newSize = (int) FastMath.ceil(this.internalArray.length * this.expansionFactor);     // Catch: Throwable -> L7
    L10:
        double[] tempArray = new double[newSize];     // Catch: Throwable -> L7
        System.arraycopy(this.internalArray, 0, tempArray, 0, this.internalArray.length);     // Catch: Throwable -> L7
        this.internalArray = tempArray;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L9:
        newSize = this.internalArray.length + FastMath.round(this.expansionFactor);     // Catch: Throwable -> L7
        goto L10
    }

    private synchronized void expandTo(int size) {
        monitor-enter(this);
        double[] tempArray = new double[size];     // Catch: Throwable -> L6
        System.arraycopy(this.internalArray, 0, tempArray, 0, this.internalArray.length);     // Catch: Throwable -> L6
        this.internalArray = tempArray;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public float getContractionCriteria() {
        return this.contractionCriteria;
    }

    @Override // org.apache.commons.math.util.DoubleArray
    public synchronized double getElement(int index) {
        monitor-enter(this);
    L9:
        th = move-exception;
        throw th;
    L4:
        if (index >= this.numElements) goto L14;
        if (index < 0) goto L12;
        double r0 = this.internalArray[this.startIndex + index];     // Catch: Throwable -> L9
        monitor-exit(this);
        return r0;
    L12:
        throw MathRuntimeException.createArrayIndexOutOfBoundsException(LocalizedFormats.CANNOT_RETRIEVE_AT_NEGATIVE_INDEX, new Object[]{Integer.valueOf(index)});     // Catch: Throwable -> L9
    L14:
        throw MathRuntimeException.createArrayIndexOutOfBoundsException(LocalizedFormats.INDEX_LARGER_THAN_MAX, new Object[]{Integer.valueOf(index), Integer.valueOf(this.numElements - 1)});     // Catch: Throwable -> L9
    }

    @Override // org.apache.commons.math.util.DoubleArray
    public synchronized double[] getElements() {
        monitor-enter(this);
        double[] elementArray = new double[this.numElements];     // Catch: Throwable -> L6
        System.arraycopy(this.internalArray, this.startIndex, elementArray, 0, this.numElements);     // Catch: Throwable -> L6
        monitor-exit(this);
        return elementArray;
    L6:
        th = move-exception;
        throw th;
    }

    public float getExpansionFactor() {
        return this.expansionFactor;
    }

    public int getExpansionMode() {
        return this.expansionMode;
    }

    synchronized int getInternalLength() {
        monitor-enter(this);
        int r0 = this.internalArray.length;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.util.DoubleArray
    public synchronized int getNumElements() {
        monitor-enter(this);
        int r0 = this.numElements;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    @Deprecated
    public synchronized double[] getValues() {
        monitor-enter(this);
        double[] r0 = this.internalArray;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized double[] getInternalValues() {
        monitor-enter(this);
        double[] r0 = this.internalArray;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public void setContractionCriteria(float contractionCriteria) {
        checkContractExpand(contractionCriteria, getExpansionFactor());
        monitor-enter(this);
        this.contractionCriteria = contractionCriteria;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // org.apache.commons.math.util.DoubleArray
    public synchronized void setElement(int index, double value) {
        monitor-enter(this);
        if (index < 0) goto L17;
        if ((index + 1) <= this.numElements) goto L11;
        this.numElements = index + 1;     // Catch: Throwable -> L8
    L11:
        if ((this.startIndex + index) < this.internalArray.length) goto L13;
        expandTo(this.startIndex + (index + 1));     // Catch: Throwable -> L8
    L13:
        this.internalArray[this.startIndex + index] = value;     // Catch: Throwable -> L8
        monitor-exit(this);
        return;
    L17:
        throw MathRuntimeException.createArrayIndexOutOfBoundsException(LocalizedFormats.CANNOT_SET_AT_NEGATIVE_INDEX, new Object[]{Integer.valueOf(index)});     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public void setExpansionFactor(float expansionFactor) {
        checkContractExpand(getContractionCriteria(), expansionFactor);
        monitor-enter(this);
        this.expansionFactor = expansionFactor;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setExpansionMode(int expansionMode) {
        if (expansionMode != 0) goto L4;
    L8:
        monitor-enter(this);
        this.expansionMode = expansionMode;     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L12:
        th = move-exception;
        throw th;
    L4:
        if (expansionMode == 1) goto L8;
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.UNSUPPORTED_EXPANSION_MODE, new Object[]{Integer.valueOf(expansionMode), 0, "MULTIPLICATIVE_MODE", 1, "ADDITIVE_MODE"});
    }

    protected void setInitialCapacity(int initialCapacity) {
        if (initialCapacity <= 0) goto L11;
        monitor-enter(this);
        this.initialCapacity = initialCapacity;     // Catch: Throwable -> L7
        monitor-exit(this);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    L11:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INITIAL_CAPACITY_NOT_POSITIVE, new Object[]{Integer.valueOf(initialCapacity)});
    }

    public synchronized void setNumElements(int i) {
        monitor-enter(this);
        if (i < 0) goto L13;
        if ((this.startIndex + i) <= this.internalArray.length) goto L9;
        expandTo(this.startIndex + i);     // Catch: Throwable -> L7
    L9:
        this.numElements = i;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L13:
        throw MathRuntimeException.createIllegalArgumentException(LocalizedFormats.INDEX_NOT_POSITIVE, new Object[]{Integer.valueOf(i)});     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        throw th;
    }

    private synchronized boolean shouldContract() {
        monitor-enter(this);
        boolean r1 = false;
        if (this.expansionMode != 0) goto L15;
        if ((this.internalArray.length / this.numElements) <= this.contractionCriteria) goto L9;
        r1 = true;
    L9:
        monitor-exit(this);
        return r1;
    L15:
        if ((this.internalArray.length - this.numElements) <= this.contractionCriteria) goto L17;
        r1 = true;
    L17:
        monitor-exit(this);
        return r1;
    L11:
        th = move-exception;
        throw th;
    }

    public synchronized int start() {
        monitor-enter(this);
        int r0 = this.startIndex;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r0;
    L6:
        th = move-exception;
        throw th;
    }

    public static void copy(ResizableDoubleArray source, ResizableDoubleArray dest) {
        monitor-enter(source);
        monitor-enter(dest);     // Catch: Throwable -> L8
        dest.initialCapacity = source.initialCapacity;     // Catch: Throwable -> L10
        dest.contractionCriteria = source.contractionCriteria;     // Catch: Throwable -> L10
        dest.expansionFactor = source.expansionFactor;     // Catch: Throwable -> L10
        dest.expansionMode = source.expansionMode;     // Catch: Throwable -> L10
        dest.internalArray = new double[source.internalArray.length];     // Catch: Throwable -> L10
        System.arraycopy(source.internalArray, 0, dest.internalArray, 0, dest.internalArray.length);     // Catch: Throwable -> L10
        dest.numElements = source.numElements;     // Catch: Throwable -> L10
        dest.startIndex = source.startIndex;     // Catch: Throwable -> L10
        monitor-exit(dest);     // Catch: Throwable -> L10
        monitor-exit(source);     // Catch: Throwable -> L8
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        throw th;
    }

    public synchronized ResizableDoubleArray copy() {
        monitor-enter(this);
        ResizableDoubleArray result = new ResizableDoubleArray();     // Catch: Throwable -> L6
        copy(this, result);     // Catch: Throwable -> L6
        monitor-exit(this);
        return result;
    L6:
        th = move-exception;
        throw th;
    }

    public boolean equals(Object object) {
        boolean result = true;
        if (object != this) goto L6;
        return true;
    L6:
        if ((object instanceof ResizableDoubleArray) == true) goto L8;
        return false;
    L8:
        monitor-enter(this);
        monitor-enter(object);     // Catch: Throwable -> L54
        ResizableDoubleArray other = (ResizableDoubleArray) object;     // Catch: Throwable -> L16
        if (1 != 0) goto L14;
    L18:
        boolean result2 = false;
    L20:
        if (result2 == true) goto L22;
    L24:
        boolean result3 = false;
    L26:
        if (result3 == true) goto L28;
    L30:
        boolean result4 = false;
    L32:
        if (result4 == true) goto L34;
    L36:
        boolean result5 = false;
    L38:
        if (result5 == true) goto L40;
    L42:
        boolean result6 = false;
    L44:
        if (result6 == true) goto L46;
    L48:
        result = false;
    L50:
        if (result == true) goto L56;
        monitor-exit(object);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L54
        return false;
    L56:
        boolean r1 = Arrays.equals(this.internalArray, other.internalArray);     // Catch: Throwable -> L16
        monitor-exit(object);     // Catch: Throwable -> L16
        monitor-exit(this);     // Catch: Throwable -> L54
        return r1;
    L46:
        if (other.startIndex != this.startIndex) goto L48;
    L40:
        if (other.numElements != this.numElements) goto L42;
        result6 = true;
        goto L44
    L34:
        if (other.expansionMode != this.expansionMode) goto L36;
        result5 = true;
        goto L38
    L28:
        if (other.expansionFactor != this.expansionFactor) goto L30;
        result4 = true;
        goto L32
    L22:
        if (other.contractionCriteria != this.contractionCriteria) goto L24;
        result3 = true;
        goto L26
    L14:
        if (other.initialCapacity != this.initialCapacity) goto L18;
        result2 = true;
    L16:
        th = move-exception;
        throw th;     // Catch: Throwable -> L54
    L54:
        th = move-exception;
        throw th;
    }

    public synchronized int hashCode() {
        monitor-enter(this);
        int[] hashData = {new Float(this.expansionFactor).hashCode(), new Float(this.contractionCriteria).hashCode(), this.expansionMode, Arrays.hashCode(this.internalArray), this.initialCapacity, this.numElements, this.startIndex};     // Catch: Throwable -> L7
        int r1 = Arrays.hashCode(hashData);     // Catch: Throwable -> L7
        monitor-exit(this);
        return r1;
    L7:
        th = move-exception;
        throw th;
    }
}
