package com.obric.autogui.agents.vlm.models.omni.intent;

import android.graphics.Bitmap;
import com.obric.autogui.agents.vlm.models.omni.r;
import com.obric.capabilitykit.common.intent.IntentResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;

/* JADX INFO: compiled from: OmniGUIIntent.kt */
/* JADX INFO: loaded from: classes3.dex */
abstract class i {

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntentResult<Bitmap> f28417a;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f28417a, r6.f28417a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public int hashCode() {
            return this.f28417a.hashCode();
        }

        public String toString() {
            return "Fail(errorResult=" + this.f28417a + ')';
        }

        public a(IntentResult<Bitmap> r2) {
            o.e(r2, "errorResult");
            super(null);
            this.f28417a = r2;
        }

        public final IntentResult<Bitmap> a() {
            return this.f28417a;
        }
    }

    /* JADX INFO: compiled from: OmniGUIIntent.kt */
    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final r f28418a;

        public b(r r2) {
            o.e(r2, "omniActions");
            super(null);
            this.f28418a = r2;
        }

        public final r a() {
            return this.f28418a;
        }
    }

    public /* synthetic */ i(d.h.b.h r1) {
        this();
    }

    private i() {
    }
}
