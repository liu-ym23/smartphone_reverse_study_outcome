package com.bytedance.android.live.ktv.common.midi;

import com.bytedance.android.live.ktv.common.model.api.g0;
import com.bytedance.android.livesdk.chatroom.o;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.live.datacontext.ConstantKt;
import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u00192\u00020\u0001:\u0001\u001aB\u0007¢\u0006\u0004\b\u0017\u0010\u0018R0\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR!\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000fR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/live/ktv/common/midi/MidiContext;", "Lcom/bytedance/live/datacontext/DataContext;", "", "", "anchorAbMap", "Ljava/util/Map;", "getAnchorAbMap", "()Ljava/util/Map;", "setAnchorAbMap", "(Ljava/util/Map;)V", "Lcom/bytedance/live/datacontext/j;", "Lcom/bytedance/android/live/ktv/common/model/api/g0;", "midiConfig$delegate", "Lcom/bytedance/live/datacontext/p;", "getMidiConfig", "()Lcom/bytedance/live/datacontext/j;", "midiConfig", "Lcom/bytedance/live/datacontext/m;", "", "style$delegate", "getStyle", "()Lcom/bytedance/live/datacontext/m;", "style", "<init>", "()V", "Companion", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class MidiContext extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    public static final int COMPONENT_MIDI_STYLE_OLD = 4;
    public static final int COMPONENT_MIDI_STYLE_V1 = 1;
    public static final int COMPONENT_MIDI_STYLE_V2 = 2;
    public static final int COMPONENT_MIDI_STYLE_V3 = 3;
    public static final a Companion = null;
    public static final String KTV_COMPONENT_NEW_MIDI = "ktv_component_new_midi";
    public static final String KTV_MIDI_SENSE_ENHANCE = "ktv_midi_sense_enhance";
    public static final int NEW_VERSION = 1;
    public static final int OLD_VERSION = 0;
    public static final String TAG = "midiEnhance";
    private Map<String, String> anchorAbMap;
    private final p midiConfig$delegate;
    private final p style$delegate;

    public static final class a {
        public a() {
        }

        @JvmStatic
        public final MidiContext getContext() {
            DataContext r100 = com.bytedance.live.datacontext.d.d(MidiContext.class);
            if ((r100 instanceof MidiContext) == true) goto L6;
            r100 = null;
        L6:
            return (MidiContext) r100;
        }

        @JvmStatic
        public final int b() {
            MidiContext r100 = getContext();
            if (r100 == null) goto L9;
            com.bytedance.live.datacontext.m<Integer> r101 = r100.getStyle();
            if (r101 == null) goto L9;
            Integer r102 = r101.getValue();
            if (r102 == null) goto L9;
            int r103 = r102.intValue();
        L10:
            MidiContext r104 = getContext();
            if (r104 == null) goto L13;
            Map<String, String> r105 = r104.getAnchorAbMap();
        L14:
            if (r103 != (-1)) goto L17;
            c(r105);
            return a(r105);
        L17:
            MidiContext r106 = getContext();
            if (r106 == null) goto L25;
            com.bytedance.live.datacontext.m<Integer> r107 = r106.getStyle();
            if (r107 == null) goto L26;
            Integer r108 = r107.getValue();
            if (r108 != null) goto L24;
            return -1;
        L24:
            return r108.intValue();
        L26:
            return -1;
        L25:
            return -1;
        L13:
            r105 = null;
        L9:
            r103 = -1;
            goto L10
        }

        @JvmStatic
        public final boolean d() {
            if (b() <= 0) goto L5;
            return true;
        L5:
            return false;
        }

        @JvmStatic
        public static int a(Map r100) {
            int r101 = vm2.d.W();
            if (r101 != 0) goto L5;
            if (r100 != null) goto L16;
            o r102 = com.bytedance.android.live.liveinteract.api.utils.m.i();
            if (r102 == null) goto L15;
            com.bytedance.live.datacontext.m<IRoom> r103 = r102.getRoom();
            if (r103 == null) goto L15;
            IRoom r104 = r103.getValue();
            if (r104 == null) goto L15;
            r100 = r104.getAnchorABMap();
        L15:
            r100 = null;
        L16:
            if (r100 == null) goto L20;
            String r105 = (String) r100.get(MidiContext.KTV_COMPONENT_NEW_MIDI);
            if (r105 == null) goto L20;
            return CastIntegerProtector.parseInt(r105);
        L20:
            return 0;
        L5:
            if (r101 == 4) goto L20;
            return vm2.d.W();
        }

        @JvmStatic
        public static boolean e(Map r100) {
            int r101 = ((Number) vm2.d.f555821e4.getValue(null, vm2.d.f555776a[262(0x106, float:3.67E-43)])).intValue();
            if (r101 == 0) goto L9;
            if (r101 != 1) goto L6;
        L22:
            int r102 = 0;
        L23:
            if (r102 <= 0) goto L26;
            return true;
        L26:
            return false;
        L6:
            if (r101 != 2) goto L22;
            r102 = 1;
            goto L23
        L9:
            if (r100 != null) goto L18;
            o r103 = com.bytedance.android.live.liveinteract.api.utils.m.i();
            if (r103 == null) goto L17;
            com.bytedance.live.datacontext.m<IRoom> r104 = r103.getRoom();
            if (r104 == null) goto L17;
            IRoom r105 = r104.getValue();
            if (r105 == null) goto L17;
            r100 = r105.getAnchorABMap();
        L17:
            r100 = null;
        L18:
            if (r100 == null) goto L22;
            String r106 = (String) r100.get(MidiContext.KTV_MIDI_SENSE_ENHANCE);
            if (r106 == null) goto L22;
            r102 = CastIntegerProtector.parseInt(r106);
            goto L23
        }

        @JvmStatic
        public final void c(Map<String, String> r100) {
            MidiContext r101 = getContext();
            if (r101 == null) goto L8;
            com.bytedance.live.datacontext.m<Integer> r102 = r101.getStyle();
            if (r102 == null) goto L9;
            r102.setValue(Integer.valueOf(a(r100)));
            return;
        L9:
            return;
        }
    }

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(MidiContext.class, "midiConfig", "getMidiConfig()Lcom/bytedance/live/datacontext/IConstantNullable;", 0)), Reflection.property1(new PropertyReference1Impl(MidiContext.class, "style", "getStyle()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0))};
        Companion = new a();
    }

    @JvmStatic
    public static final int getComponentNewMidiStyle(Map<String, String> r100) {
        Companion.getClass();
        return a.a(r100);
    }

    @JvmStatic
    public static final MidiContext getContext() {
        return Companion.getContext();
    }

    @JvmStatic
    public static final int getResultCache() {
        return Companion.b();
    }

    @JvmStatic
    public static final void initComponentMidiStyle(Map<String, String> r100) {
        Companion.c(r100);
    }

    @JvmStatic
    public static final boolean isComponentNewMidi() {
        return Companion.d();
    }

    @JvmStatic
    public static final boolean isEnforceStyle(Map<String, String> r100) {
        Companion.getClass();
        return a.e(r100);
    }

    public final com.bytedance.live.datacontext.j<g0> getMidiConfig() {
        return (com.bytedance.live.datacontext.j) this.midiConfig$delegate.a(this, $$delegatedProperties[0]);
    }

    public final com.bytedance.live.datacontext.m<Integer> getStyle() {
        return (com.bytedance.live.datacontext.m) this.style$delegate.a(this, $$delegatedProperties[1]);
    }

    @JvmStatic
    public static final boolean isComponentEnableNextLineForGuest() {
        a r100 = Companion;
        if (r100.b() != 1) goto L5;
        return true;
    L5:
        if (r100.b() != 2) goto L7;
        return true;
    L7:
        if (r100.b() == 0) goto L13;
        return false;
    L13:
        return true;
    }

    @JvmStatic
    public static final boolean isComponentMidiShowHitAnimation() {
        a r100 = Companion;
        if (r100.b() != 1) goto L5;
        return true;
    L5:
        if (r100.b() == 3) goto L10;
        return false;
    L10:
        return true;
    }

    @JvmStatic
    public static final boolean isComponentMidiShowHitTypeFb() {
        if (Companion.b() == 1) goto L7;
        return false;
    L7:
        return true;
    }

    @JvmStatic
    public static final boolean isComponentMidiShowScore() {
        a r100 = Companion;
        if (r100.b() != 1) goto L5;
        return true;
    L5:
        if (r100.b() == 2) goto L10;
        return false;
    L10:
        return true;
    }

    @JvmStatic
    public static final boolean isComponentMidiShowTail() {
        a r100 = Companion;
        if (r100.b() != 1) goto L5;
        return true;
    L5:
        if (r100.b() == 3) goto L10;
        return false;
    L10:
        return true;
    }

    public MidiContext() {
        this.midiConfig$delegate = ConstantKt.c(this);
        this.style$delegate = q.d(this, -1);
    }

    public final Map<String, String> getAnchorAbMap() {
        return this.anchorAbMap;
    }

    public final void setAnchorAbMap(Map<String, String> r100) {
        this.anchorAbMap = r100;
    }
}
