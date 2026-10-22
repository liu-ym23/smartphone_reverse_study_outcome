package com.obric.autogui.agents.scripted.a;

import com.google.gson.annotations.SerializedName;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import d.h.b.o;
import java.io.Serializable;

/* JADX INFO: compiled from: NextScriptParams.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements Serializable {

    /* JADX INFO: compiled from: NextScriptParams.kt */
    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @SerializedName("success")
        private final Boolean f26855a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @SerializedName("data")
        private final j f26856b;

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if (ZeusTransformUtils.instanceOf(r5, a.class) == true) goto L8;
            return false;
        L8:
            a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.aiagent.plugin");
            if (o.a(this.f26855a, r6.f26855a) == true) goto L12;
            return false;
        L12:
            if (o.a(this.f26856b, r6.f26856b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            Boolean r0 = this.f26855a;
            int r1 = 0;
            if (r0 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = r2 * 31;
            j r4 = this.f26856b;
            if (r4 == null) goto L11;
            r1 = r4.hashCode();
        L11:
            return r3 + r1;
        L5:
            r2 = r0.hashCode();
            goto L6
        }

        public String toString() {
            return "SuccessResponse(success=" + this.f26855a + ", data=" + this.f26856b + ')';
        }

        public a(Boolean r2, j r3) {
            super(null);
            this.f26855a = r2;
            this.f26856b = r3;
        }
    }

    public /* synthetic */ b(d.h.b.h r1) {
        this();
    }

    private b() {
    }
}
