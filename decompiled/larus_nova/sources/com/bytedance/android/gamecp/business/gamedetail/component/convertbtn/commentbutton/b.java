package com.bytedance.android.gamecp.business.gamedetail.component.convertbtn.commentbutton;

import com.bytedance.ies.sve_core.s;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes44.dex */
public final class b implements s {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f54201b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final JSONObject f54202a;

    public static final class a {
    }

    static {
    }

    public b() {
        this(null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof b) == true) goto L6;
        return false;
    L6:
        if (Intrinsics.areEqual(this.f54202a, ((b) r100).f54202a) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        JSONObject r100 = this.f54202a;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.hashCode();
    }

    public final String toString() {
        return "NewCommentButtonState(nodeData=" + this.f54202a + ")";
    }

    public b(JSONObject r100) {
        this.f54202a = r100;
    }
}
