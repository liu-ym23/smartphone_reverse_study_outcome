package com.bytedance.android.livesdk.ktvimpl.base.sei;

import com.google.gson.annotations.SerializedName;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\b\b\u0086\b\u0018\u00002\u00020\u0001:\u0001\tR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\n"}, d2 = {"Lcom/bytedance/android/livesdk/ktvimpl/base/sei/r;", "Lcom/bytedance/android/livesdk/ktvimpl/base/sei/a;", "", "midiUsers", "Ljava/lang/Object;", "b", "()Ljava/lang/Object;", "setMidiUsers", "(Ljava/lang/Object;)V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livektv-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class r extends com.bytedance.android.livesdk.ktvimpl.base.sei.a {

    @SerializedName("midiUsers")
    private Object midiUsers;

    public static final class a {
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof r) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.midiUsers, ((r) r100).midiUsers) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.midiUsers;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "RtChorusMidiScoreSeiModel(midiUsers=" + this.midiUsers + ")";
    }

    public r() {
        this.midiUsers = null;
    }

    public final Object b() {
        return this.midiUsers;
    }
}
