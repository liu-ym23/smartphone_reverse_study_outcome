package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar.bubble.utils;

import com.bytedance.android.live.core.log.ALogger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class MorePanelBubbleAlog {

    public static final class SimpleAlogArgsBuilder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Lazy f115852a;

        public final a b() {
            return new a(((StringBuilder) this.f115852a.getValue()).toString());
        }

        public SimpleAlogArgsBuilder() {
            this.f115852a = LazyKt.lazy(MorePanelBubbleAlog$SimpleAlogArgsBuilder$strBuilder$2.INSTANCE);
        }

        public final void c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            ((StringBuilder) this.f115852a.getValue()).append(r100 + '.');
        }

        public final void d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            ((StringBuilder) this.f115852a.getValue()).append("tag:" + r100 + '\t');
        }

        public final void a(String r100, Object r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "value");
            ((StringBuilder) this.f115852a.getValue()).append("the " + r100 + " is " + r101 + '.');
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f115853a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f115854b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f115853a, r101.f115853a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.f115854b, r101.f115854b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r100 = this.f115853a;
            int r101 = 0;
            if (r100 == null) goto L5;
            int r102 = r100.hashCode();
        L6:
            int r103 = r102 * 31;
            Throwable r104 = this.f115854b;
            if (r104 == null) goto L10;
            r101 = r104.hashCode();
        L10:
            return r103 + r101;
        L5:
            r102 = 0;
            goto L6
        }

        public final String toString() {
            return "SimpleAlogArgs(msg=" + this.f115853a + ", error=" + this.f115854b + ")";
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "msg");
            this.f115853a = r100;
            this.f115854b = null;
        }
    }

    static {
    }

    @JvmStatic
    public static final void a(a r100) {
        Intrinsics.checkNotNullParameter(r100, "args");
        Throwable r101 = r100.f115854b;
        if (r101 == null) goto L5;
        ALogger.e("MorePanelBubbleAlog", r100.f115853a, r101);
        return;
    L5:
        ALogger.i("MorePanelBubbleAlog", r100.f115853a);
        Unit r102 = Unit.INSTANCE;
    }
}
