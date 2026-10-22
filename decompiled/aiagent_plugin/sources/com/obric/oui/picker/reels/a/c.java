package com.obric.oui.picker.reels.a;

import android.content.Context;
import android.util.AttributeSet;
import com.bytedance.common.wschannel.WsChannelMultiProcessSharedProvider;
import com.obric.aiagent.plugin.R;
import com.obric.oui.picker.reels.views.OReelPickerThreeReels;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.h;
import d.h.b.o;
import java.util.function.Consumer;

/* JADX INFO: compiled from: OReelPickerTimeLength.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f35935a;

    /* JADX INFO: compiled from: OReelPickerTimeLength.kt */
    public static final class a implements com.obric.oui.picker.reels.a.b<c, b> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f35936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private boolean f35937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f35938c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private Consumer<b> f35939d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private b f35940e;
        private b f;
        private b g;
        private com.obric.oui.picker.reels.a h;
        private final C0971a i;

        /* JADX INFO: renamed from: com.obric.oui.picker.reels.a.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: OReelPickerTimeLength.kt */
        public final class C0971a implements com.obric.oui.picker.reels.a.c {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ a f35941a;

            static /* synthetic */ void a(C0971a r1, int r2, int r3, int r4, int r5, Object r6) {
                if ((r5 & 1) == 0) goto L6;
                r2 = -1;
            L6:
                if ((r5 & 2) == 0) goto L9;
                r3 = -1;
            L9:
                if ((r5 & 4) == 0) goto L11;
                r4 = -1;
            L11:
                r1.a(r2, r3, r4);
            }

            private final void a(int r2, int r3, int r4) {
                if (r2 < 0) goto L4;
                this.f35941a.a().a(r2);
            L4:
                if (r3 < 0) goto L6;
                this.f35941a.a().b(r3);
            L6:
                if (r4 < 0) goto L8;
                this.f35941a.a().c(r4);
            L8:
                a();
            }

            private final void a() {
                Consumer r0 = a.a(this.f35941a);
                if (r0 == null) goto L7;
                r0.accept(this.f35941a.a());
                return;
            }

            @Override // com.obric.oui.picker.reels.a.c
            public void onReelChanged(int r14, int r15) {
                if (r14 != 0) goto L4;
                a(this, this.f35941a.b().a() + r15, 0, 0, 6, null);
            L11:
                a();
                return;
            L4:
                if (r14 != 1) goto L6;
                a(this, 0, this.f35941a.b().b() + r15, 0, 5, null);
                goto L11
            L6:
                if (r14 != 2) goto L11;
                a(this, 0, 0, this.f35941a.b().c() + r15, 3, null);
                goto L11
            }
        }

        public static final /* synthetic */ Consumer a(a r0) {
            return r0.f35939d;
        }

        @Override // com.obric.oui.picker.reels.a.b
        public /* synthetic */ c b(Context r3, AttributeSet r4, int r5) {
            return a((Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin"), (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin"), r5);
        }

        public final b a() {
            return this.f35940e;
        }

        public final b b() {
            return this.f;
        }

        public final void a(com.obric.oui.picker.reels.a r3) {
            this.h = (com.obric.oui.picker.reels.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.oui.picker.reels.a.class, "com.obric.aiagent.plugin");
        }

        private final com.obric.oui.picker.reels.a.b a(Context r23) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
            if (this.f35936a == true) goto L7;
            return null;
        L7:
            return new com.obric.oui.picker.reels.a.b(0, d.a(d.f35945a, this.f.a(), this.g.a(), null, 0, 12, null), (CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_tag_hour, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_tag_hour")), CharSequence.class, "com.obric.aiagent.plugin"), 0.0f, null, null, null, this.f35940e.a() - this.f.a(), (com.obric.oui.picker.reels.a.c) ZeusTransformUtils.preCheckCast(this.i, com.obric.oui.picker.reels.a.c.class, "com.obric.aiagent.plugin"), 120, null);
        }

        private final com.obric.oui.picker.reels.a.b b(Context r23) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
            if (this.f35937b == true) goto L7;
            return null;
        L7:
            return new com.obric.oui.picker.reels.a.b(1, d.a(d.f35945a, this.f.b(), this.g.b(), null, 0, 12, null), (CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_tag_minute, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_tag_minute")), CharSequence.class, "com.obric.aiagent.plugin"), 0.0f, null, null, null, this.f35940e.b() - this.f.b(), (com.obric.oui.picker.reels.a.c) ZeusTransformUtils.preCheckCast(this.i, com.obric.oui.picker.reels.a.c.class, "com.obric.aiagent.plugin"), 120, null);
        }

        private final com.obric.oui.picker.reels.a.b c(Context r23) {
            Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r23, Context.class, "com.obric.aiagent.plugin");
            if (this.f35938c == true) goto L7;
            return null;
        L7:
            return new com.obric.oui.picker.reels.a.b(2, d.a(d.f35945a, this.f.c(), this.g.c(), null, 0, 12, null), (CharSequence) ZeusTransformUtils.preCheckCast(r1.getString(ZeusTransformUtils.mapRes(R.string.oui_reel_tag_second, WsChannelMultiProcessSharedProvider.STRING_TYPE, "oui_reel_tag_second")), CharSequence.class, "com.obric.aiagent.plugin"), 0.0f, null, null, null, this.f35940e.c() - this.f.c(), (com.obric.oui.picker.reels.a.c) ZeusTransformUtils.preCheckCast(this.i, com.obric.oui.picker.reels.a.c.class, "com.obric.aiagent.plugin"), 120, null);
        }

        public c a(Context r3, AttributeSet r4, int r5) {
            Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.aiagent.plugin");
            AttributeSet r7 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r4, AttributeSet.class, "com.obric.aiagent.plugin");
            o.e(r6, "context");
            OReelPickerThreeReels.a r0 = new OReelPickerThreeReels.a();
            com.obric.oui.picker.reels.a.b r1 = a(r6);
            if (r1 == null) goto L6;
            r0.a(r1);
        L6:
            com.obric.oui.picker.reels.a.b r2 = b(r6);
            if (r2 == null) goto L10;
            r0.a(r2);
        L10:
            com.obric.oui.picker.reels.a.b r8 = c(r6);
            if (r8 == null) goto L14;
            r0.a(r8);
        L14:
            com.obric.oui.picker.reels.a r9 = r0.a(r6, r7, r5);
            c r10 = new c();
            a(r9);
            c.a(r10, this);
            return r10;
        }
    }

    /* JADX INFO: compiled from: OReelPickerTimeLength.kt */
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f35942a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f35943b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f35944c;

        public b() {
            this(0, 0, 0, 7, null);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, b.class) == true) goto L8;
            return false;
        L8:
            b r6 = (b) ZeusTransformUtils.preCheckCast(r5, b.class, "com.obric.aiagent.plugin");
            if (this.f35942a == r6.f35942a) goto L12;
            return false;
        L12:
            if (this.f35943b == r6.f35943b) goto L15;
            return false;
        L15:
            if (this.f35944c == r6.f35944c) goto L17;
            return false;
        L17:
            return true;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.f35942a) * 31) + Integer.hashCode(this.f35943b)) * 31) + Integer.hashCode(this.f35944c);
        }

        public String toString() {
            return "TimeLength(hour=" + this.f35942a + ", minute=" + this.f35943b + ", second=" + this.f35944c + ')';
        }

        public b(int r1, int r2, int r3) {
            this.f35942a = r1;
            this.f35943b = r2;
            this.f35944c = r3;
        }

        public /* synthetic */ b(int r2, int r3, int r4, int r5, h r6) {
            if ((r5 & 1) == 0) goto L6;
            r2 = 0;
        L6:
            if ((r5 & 2) == 0) goto L9;
            r3 = 0;
        L9:
            if ((r5 & 4) == 0) goto L11;
            r4 = 0;
        L11:
            this(r2, r3, r4);
        }

        public final int a() {
            return this.f35942a;
        }

        public final void a(int r1) {
            this.f35942a = r1;
        }

        public final int b() {
            return this.f35943b;
        }

        public final void b(int r1) {
            this.f35943b = r1;
        }

        public final int c() {
            return this.f35944c;
        }

        public final void c(int r1) {
            this.f35944c = r1;
        }
    }

    public c() {
    }

    public static final /* synthetic */ void a(c r0, a r1) {
        r0.f35935a = r1;
    }

    public b a() {
        a r0 = this.f35935a;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.a();
    }
}
