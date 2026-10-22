package com.obric.oui.picker.reels.a;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.common.util.g;
import com.obric.oui.picker.reels.views.OReelPickerMulti;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.a.ao;
import d.h.b.h;
import d.h.b.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

/* JADX INFO: compiled from: OReelDynamicPicker.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private C0970a f35928a;

    /* JADX INFO: renamed from: com.obric.oui.picker.reels.a.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: OReelDynamicPicker.kt */
    public static final class C0970a implements com.obric.oui.picker.reels.a.b<a, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Consumer<b> f35929a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f35930b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Integer f35931c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final List<com.obric.oui.picker.reels.a.b> f35932d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final Map<Integer, Integer> f35933e;
        private com.obric.oui.picker.reels.a f;
        private final com.obric.oui.picker.reels.a.c g;

        /* JADX INFO: renamed from: lambda$HhLBYL-h7acWLi4pKGodhKXNQ1I, reason: not valid java name */
        public static /* synthetic */ void m1115lambda$HhLBYLh7acWLi4pKGodhKXNQ1I(C0970a r0, int r1, int r2) {
            a(r0, r1, r2);
        }

        public C0970a() {
            this.f35932d = (List) ZeusTransformUtils.preCheckCast(new ArrayList(), List.class, "com.obric.aiagent.plugin");
            this.f35933e = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.aiagent.plugin");
            this.g = new $$Lambda$a$a$HhLBYLh7acWLi4pKGodhKXNQ1I(this);
        }

        @Override // com.obric.oui.picker.reels.a.b
        public /* synthetic */ a b(Context r3, AttributeSet r4, int r5) {
            return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        }

        public final com.obric.oui.picker.reels.a a() {
            return this.f;
        }

        public final C0970a a(int r1) {
            this.f35930b = Integer.valueOf(r1);
            return this;
        }

        public final C0970a b(int r1) {
            this.f35931c = Integer.valueOf(r1);
            return this;
        }

        private static final void a(C0970a r1, int r2, int r3) {
            o.e(r1, "this$0");
            r1.f35933e.put(Integer.valueOf(r2), Integer.valueOf(r3));
            r1.b();
        }

        private final void b() {
            Consumer<b> r0 = this.f35929a;
            if (r0 == null) goto L7;
            r0.accept(new b(ao.d(this.f35933e)));
            return;
        }

        public static /* synthetic */ C0970a a(C0970a r9, int r10, List r11, String r12, int r13, float r14, Integer r15, Integer r16, Context r17, int r18, Object r19) {
            List<String> r1 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.aiagent.plugin");
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r17, Context.class, "com.obric.aiagent.plugin");
            if ((r18 & 4) == 0) goto L5;
            String r3 = null;
        L7:
            if ((r18 & 8) == 0) goto L9;
            int r5 = 0;
        L11:
            if ((r18 & 16) == 0) goto L13;
            float r6 = 1.0f;
        L15:
            if ((r18 & 32) == 0) goto L17;
            Integer r7 = null;
        L19:
            if ((r18 & 64) == 0) goto L21;
            Integer r8 = null;
        L23:
            if ((r18 & 128) == 0) goto L26;
            r2 = null;
        L26:
            return r9.a(r10, r1, r3, r5, r6, r7, r8, r2);
        L21:
            r8 = r16;
            goto L23
        L17:
            r7 = r15;
            goto L19
        L13:
            r6 = r14;
            goto L15
        L9:
            r5 = r13;
            goto L11
        L5:
            r3 = r12;
            goto L7
        }

        public final C0970a a(int r16, List<String> r17, String r18, int r19, float r20, Integer r21, Integer r22, Context r23) {
            List r6 = (List) ZeusTransformUtils.wrapperContextForParams(r17, List.class, "com.obric.aiagent.plugin");
            Context r2 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
            o.e(r6, "entries");
            if (r21 != null) goto L11;
            if (r2 == null) goto L11;
            if (r18 != null) goto L9;
            if (r22 != null) goto L9;
            Integer r3 = Integer.valueOf(g.a(r2, 72));
        L10:
            Integer r10 = r3;
        L12:
            this.f35932d.add(new com.obric.oui.picker.reels.a.b(r16, r6, (CharSequence) ZeusTransformUtils.preCheckCast(r18, CharSequence.class, "com.obric.aiagent.plugin"), r20, r21, r10, r22, r19, this.g));
            this.f35933e.put(Integer.valueOf(r16), Integer.valueOf(r19));
            return this;
        L9:
            r3 = Integer.valueOf(g.a(r2, 92));
        L11:
            r10 = r21;
            goto L12
        }

        public final C0970a a(Context r23, int r24, int r25, int r26, Integer r27, Integer r28) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            d r4 = d.f35945a;
            String r7 = r1.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_picker_year_tag, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_year_tag"));
            o.c(r7, "context.getString(R.stri…oui_reel_picker_year_tag)");
            List r13 = d.a(r4, r25, r26, r7, 0, 8, null);
            if (r27 != null) goto L5;
            int r15 = 0;
        L7:
            if (r28 != null) goto L9;
            int r0 = g.a(r1, 101);
        L11:
            return a(this, r24, r13, null, r15, 0.0f, Integer.valueOf(r0), null, null, 208, null);
        L9:
            r0 = r28.intValue();
            goto L11
        L5:
            r15 = Math.max(0, Math.min(((Number) ZeusTransformUtils.preCheckCast(r27, Number.class, "com.obric.aiagent.plugin")).intValue() - r25, r13.size() - 1));
            goto L7
        }

        public static /* synthetic */ C0970a a(C0970a r1, Context r2, int r3, Integer r4, Integer r5, int r6, Object r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = 1002;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = null;
        L12:
            return r1.a(r8, r3, r4, r5);
        }

        public final C0970a a(Context r18, int r19, Integer r20, Integer r21) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r18, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            List<String> r8 = d.f35945a.a(r1, 1, 12);
            if (r20 != null) goto L5;
            int r10 = 0;
        L7:
            if (r21 != null) goto L9;
            int r0 = g.a(r1, 101);
        L11:
            return a(this, r19, r8, null, r10, 0.0f, Integer.valueOf(r0), null, null, 208, null);
        L9:
            r0 = r21.intValue();
            goto L11
        L5:
            r10 = Math.max(0, Math.min(((Number) ZeusTransformUtils.preCheckCast(r20, Number.class, "com.obric.aiagent.plugin")).intValue() - 1, 11));
            goto L7
        }

        public static /* synthetic */ C0970a b(C0970a r1, Context r2, int r3, Integer r4, Integer r5, int r6, Object r7) {
            Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.aiagent.plugin");
            if ((r6 & 2) == 0) goto L6;
            r3 = 1003;
        L6:
            if ((r6 & 4) == 0) goto L9;
            r4 = null;
        L9:
            if ((r6 & 8) == 0) goto L12;
            r5 = null;
        L12:
            return r1.b(r8, r3, r4, r5);
        }

        public final C0970a b(Context r23, int r24, Integer r25, Integer r26) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
            o.e(r1, "context");
            d r4 = d.f35945a;
            String r7 = r1.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_picker_day_tag, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_picker_day_tag"));
            o.c(r7, "context.getString(R.stri….oui_reel_picker_day_tag)");
            List r13 = d.a(r4, 1, 31, r7, 0, 8, null);
            if (r25 != null) goto L5;
            int r15 = 0;
        L7:
            if (r26 != null) goto L9;
            int r0 = g.a(r1, 101);
        L11:
            return a(this, r24, r13, null, r15, 0.0f, Integer.valueOf(r0), null, null, 208, null);
        L9:
            r0 = r26.intValue();
            goto L11
        L5:
            r15 = Math.max(0, Math.min(((Number) ZeusTransformUtils.preCheckCast(r25, Number.class, "com.obric.aiagent.plugin")).intValue() - 1, 30));
            goto L7
        }

        public static /* synthetic */ C0970a a(C0970a r4, Context r5, int r6, boolean r7, boolean r8, Integer r9, Integer r10, int r11, Object r12) {
            Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.aiagent.plugin");
            if ((r11 & 2) == 0) goto L5;
            r6 = 1004;
        L5:
            int r14 = r6;
            boolean r0 = true;
            if ((r11 & 4) == 0) goto L8;
            boolean r1 = true;
        L10:
            if ((r11 & 8) != 0) goto L14;
            r0 = r8;
        L14:
            if ((r11 & 16) == 0) goto L16;
            Integer r2 = null;
        L18:
            if ((r11 & 32) == 0) goto L20;
            Integer r3 = null;
        L22:
            return r4.a(r13, r14, r1, r0, r2, r3);
        L20:
            r3 = r10;
            goto L22
        L16:
            r2 = r9;
            goto L18
        L8:
            r1 = r7;
            goto L10
        }

        public final C0970a a(Context r15, int r16, boolean r17, boolean r18, Integer r19, Integer r20) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
            o.e(r11, "context");
            int r1 = !r17 ? 1 : 0;
            if (r17 == false) goto L5;
            int r3 = 23;
        L6:
            List r5 = d.a(d.f35945a, r1, r3, "", 0, 8, null);
            Integer r4 = null;
            if (r18 == false) goto L9;
            String r6 = r11.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_tag_hour, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_tag_hour"));
        L10:
            if (r18 == false) goto L12;
            r4 = Integer.valueOf(g.a(r11, 2));
        L12:
            Integer r10 = r4;
            if (r19 != null) goto L15;
            int r7 = 0;
        L17:
            return a(this, r16, r5, r6, r7, 0.0f, r20, r10, r11, 16, null);
        L15:
            r7 = Math.max(0, Math.min(((Number) ZeusTransformUtils.preCheckCast(r19, Number.class, "com.obric.aiagent.plugin")).intValue() - r1, r5.size() - 1));
            goto L17
        L9:
            r6 = null;
            goto L10
        L5:
            r3 = 12;
            goto L6
        }

        public static /* synthetic */ C0970a a(C0970a r3, Context r4, int r5, boolean r6, Integer r7, Integer r8, int r9, Object r10) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.aiagent.plugin");
            if ((r9 & 2) == 0) goto L5;
            r5 = 1005;
        L5:
            int r12 = r5;
            if ((r9 & 4) == 0) goto L8;
            r6 = true;
        L8:
            boolean r0 = r6;
            if ((r9 & 8) == 0) goto L11;
            Integer r1 = null;
        L13:
            if ((r9 & 16) == 0) goto L15;
            Integer r2 = null;
        L17:
            return r3.a(r11, r12, r0, r1, r2);
        L15:
            r2 = r8;
            goto L17
        L11:
            r1 = r7;
            goto L13
        }

        public final C0970a a(Context r15, int r16, boolean r17, Integer r18, Integer r19) {
            Context r11 = (Context) ZeusTransformUtils.wrapperContextForParams(r15, Context.class, "com.obric.aiagent.plugin");
            o.e(r11, "context");
            List r5 = d.a(d.f35945a, 0, 59, "", 0, 8, null);
            Integer r1 = null;
            if (r17 == false) goto L5;
            String r6 = r11.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_tag_minute, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_tag_minute"));
        L6:
            if (r17 == false) goto L8;
            r1 = Integer.valueOf(g.a(r11, 2));
        L8:
            Integer r10 = r1;
            if (r18 != null) goto L11;
            int r7 = 0;
        L13:
            return a(this, r16, r5, r6, r7, 0.0f, r19, r10, r11, 16, null);
        L11:
            r7 = Math.max(0, Math.min(((Number) ZeusTransformUtils.preCheckCast(r18, Number.class, "com.obric.aiagent.plugin")).intValue(), 59));
            goto L13
        L5:
            r6 = null;
            goto L6
        }

        public void a(Consumer<b> r3) {
            Consumer<b> r4 = (Consumer) ZeusTransformUtils.wrapperContextForParams(r3, Consumer.class, "com.obric.aiagent.plugin");
            o.e(r4, "listener");
            this.f35929a = r4;
        }

        public a a(Context r6, AttributeSet r7, int r8) {
            Context r9 = (Context) ZeusTransformUtils.wrapperContextForParams(r6, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r10 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r7, AttributeSet.class, "com.obric.aiagent.plugin");
            o.e(r9, "context");
            OReelPickerMulti.a r0 = new OReelPickerMulti.a();
            Integer r2 = this.f35930b;
            if (r2 == null) goto L6;
            r0.a(((Number) ZeusTransformUtils.preCheckCast(r2, Number.class, "com.obric.aiagent.plugin")).intValue());
        L6:
            Integer r3 = this.f35931c;
            if (r3 == null) goto L10;
            r0.b(((Number) ZeusTransformUtils.preCheckCast(r3, Number.class, "com.obric.aiagent.plugin")).intValue());
        L10:
            Iterator r4 = ((Iterable) ZeusTransformUtils.preCheckCast(this.f35932d, Iterable.class, "com.obric.aiagent.plugin")).iterator();
        L12:
            if (r4.hasNext() == false) goto L14;
            r0.a((com.obric.oui.picker.reels.a.b) ZeusTransformUtils.preCheckCast(r4.next(), com.obric.oui.picker.reels.a.b.class, "com.obric.aiagent.plugin"));
            goto L12
        L14:
            this.f = r0.a(r9, r10, r8);
            a r11 = new a();
            a.a(r11, this);
            return r11;
        }
    }

    /* JADX INFO: compiled from: OReelDynamicPicker.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map<Integer, Integer> f35934a;

        /* JADX WARN: Multi-variable type inference failed */
        public b() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (o.a(this.f35934a, r6.f35934a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f35934a.hashCode();
        }

        public String toString() {
            return "PickedData(selections=" + this.f35934a + ')';
        }

        public b(Map<Integer, Integer> r3) {
            Map<Integer, Integer> r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r3, Map.class, "com.obric.aiagent.plugin");
            o.e(r4, "selections");
            this.f35934a = r4;
        }

        public /* synthetic */ b(Map r2, int r3, h r4) {
            Map r5 = (Map) ZeusTransformUtils.wrapperContextForParams(r2, Map.class, "com.obric.aiagent.plugin");
            if ((r3 & 1) == 0) goto L5;
            r5 = ao.b();
        L5:
            this(r5);
        }

        public final Map<Integer, Integer> a() {
            return this.f35934a;
        }
    }

    public a() {
    }

    public static final /* synthetic */ void a(a r0, C0970a r1) {
        r0.f35928a = r1;
    }

    public View a() {
        C0970a r1 = this.f35928a;
        if (r1 == null) goto L10;
        com.obric.oui.picker.reels.a r2 = r1.a();
        if (r2 != null) goto L9;
        return null;
    L9:
        return r2.asView();
    L10:
        return null;
    }
}
