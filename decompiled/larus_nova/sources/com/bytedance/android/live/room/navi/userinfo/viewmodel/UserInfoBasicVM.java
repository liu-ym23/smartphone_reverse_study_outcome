package com.bytedance.android.live.room.navi.userinfo.viewmodel;

import com.bytedance.live.datacontext.DataContext;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import g91.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u001e\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002R!\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR)\u0010\u000f\u001a\u0014\u0012\u0006\b\u0001\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\u000e8\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\fR!\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo/viewmodel/UserInfoBasicVM;", "Lcom/bytedance/live/datacontext/DataContext;", "", "firstLineDesc", "secondLineDesc", "", "updateAccessibilityDesc", "Lcom/bytedance/live/datacontext/m;", "Lg91/a;", "_anchorContentDesc$delegate", "Lcom/bytedance/live/datacontext/p;", "get_anchorContentDesc", "()Lcom/bytedance/live/datacontext/m;", "_anchorContentDesc", "Lcom/bytedance/android/live/core/utils/IReadonlyNonNull;", "anchorContentDesc", "Lcom/bytedance/live/datacontext/m;", "getAnchorContentDesc", "Lcom/bytedance/live/datacontext/k;", "showProfile$delegate", "getShowProfile", "()Lcom/bytedance/live/datacontext/k;", "showProfile", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class UserInfoBasicVM extends DataContext {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p _anchorContentDesc$delegate;
    private final m<? extends a> anchorContentDesc;
    private final p showProfile$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(UserInfoBasicVM.class, "_anchorContentDesc", "get_anchorContentDesc()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(UserInfoBasicVM.class, "showProfile", "getShowProfile()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
    }

    private final m<a> get_anchorContentDesc() {
        return (m) this._anchorContentDesc$delegate.a(this, $$delegatedProperties[0]);
    }

    public final k<Unit> getShowProfile() {
        return (k) this.showProfile$delegate.a(this, $$delegatedProperties[1]);
    }

    public UserInfoBasicVM() {
        this._anchorContentDesc$delegate = q.d(this, new a());
        this.anchorContentDesc = get_anchorContentDesc();
        this.showProfile$delegate = e.b(this);
    }

    public final m<? extends a> getAnchorContentDesc() {
        return this.anchorContentDesc;
    }

    public final void updateAccessibilityDesc(String r100, String r101) {
        a r102 = get_anchorContentDesc().getValue();
        boolean r103 = true;
        if (r100 != null) goto L5;
    L13:
        if (r101 != null) goto L15;
    L23:
        get_anchorContentDesc().setValue(r102);
        return;
    L15:
        if (r101.length() > 0) goto L18;
        r103 = false;
    L18:
        if (r103 == true) goto L21;
        r101 = null;
    L21:
        if (r101 == null) goto L23;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r101, "<set-?>");
        r102.f480473b = r101;
        goto L23
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r104 = true;
    L8:
        if (r104 == true) goto L11;
        r100 = null;
    L11:
        if (r100 == null) goto L13;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r102.f480472a = r100;
        goto L13
    L7:
        r104 = false;
        goto L8
    }

    public static /* synthetic */ void updateAccessibilityDesc$default(UserInfoBasicVM r100, String r101, String r102, int r103, Object r104) {
        if ((r103 & 1) == 0) goto L6;
        r101 = "";
    L6:
        if ((r103 & 2) == 0) goto L8;
        r102 = "";
    L8:
        r100.updateAccessibilityDesc(r101, r102);
    }
}
