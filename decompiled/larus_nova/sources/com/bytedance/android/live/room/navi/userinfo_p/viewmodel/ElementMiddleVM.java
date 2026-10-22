package com.bytedance.android.live.room.navi.userinfo_p.viewmodel;

import com.bytedance.android.live.room.navi.userinfo_p.viewmodel.base.BaseUiVM;
import com.bytedance.android.livesdk.message.model.ii;
import com.bytedance.live.datacontext.e;
import com.bytedance.live.datacontext.k;
import com.bytedance.live.datacontext.m;
import com.bytedance.live.datacontext.n;
import com.bytedance.live.datacontext.p;
import com.bytedance.live.datacontext.q;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import z91.b;
import z91.c;
import z91.d;

/* JADX INFO: loaded from: classes47.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b5\u00106J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR!\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u0010R!\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\t\u001a\u0004\b\u0013\u0010\u0010R!\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00040\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0016\u0010\u0010R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00180\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\t\u001a\u0004\b\u001a\u0010\u0010R!\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000bR!\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000bR!\u0010%\u001a\b\u0012\u0004\u0012\u00020\u001c0\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000bR!\u0010+\u001a\b\u0012\u0004\u0012\u00020'0&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\t\u001a\u0004\b)\u0010*R!\u0010.\u001a\b\u0012\u0004\u0012\u00020,0\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b-\u0010\t\u001a\u0004\b.\u0010\u000bR!\u00101\u001a\b\u0012\u0004\u0012\u00020\u001c0&8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\t\u001a\u0004\b0\u0010*R!\u00104\u001a\b\u0012\u0004\u0012\u00020\u00040\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u0010¨\u00067"}, d2 = {"Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/ElementMiddleVM;", "Lcom/bytedance/android/live/room/navi/userinfo_p/viewmodel/base/BaseUiVM;", "Lz91/a;", "action", "", "reduce", "Lcom/bytedance/live/datacontext/m;", "", "userNameLayoutRightMarginDP$delegate", "Lcom/bytedance/live/datacontext/p;", "getUserNameLayoutRightMarginDP", "()Lcom/bytedance/live/datacontext/m;", "userNameLayoutRightMarginDP", "Lcom/bytedance/live/datacontext/k;", "onFollowCanceled$delegate", "getOnFollowCanceled", "()Lcom/bytedance/live/datacontext/k;", "onFollowCanceled", "onFollowSuccess$delegate", "getOnFollowSuccess", "onFollowSuccess", "renderEmpty$delegate", "getRenderEmpty", "renderEmpty", "Ly91/a;", "showProfileViewAnim$delegate", "getShowProfileViewAnim", "showProfileViewAnim", "", "userNameLayoutMaxWidthPx$delegate", "getUserNameLayoutMaxWidthPx", "userNameLayoutMaxWidthPx", "userNameLayoutCurWidthPx$delegate", "getUserNameLayoutCurWidthPx", "userNameLayoutCurWidthPx", "dslLabelWidth$delegate", "getDslLabelWidth", "dslLabelWidth", "Lcom/bytedance/live/datacontext/n;", "Lcom/bytedance/android/livesdk/message/model/ii;", "appointmentMessage$delegate", "getAppointmentMessage", "()Lcom/bytedance/live/datacontext/n;", "appointmentMessage", "", "isAppointmentShowing$delegate", "isAppointmentShowing", "userNameViewVisibility$delegate", "getUserNameViewVisibility", "userNameViewVisibility", "changeHeightWhenEmpty$delegate", "getChangeHeightWhenEmpty", "changeHeightWhenEmpty", "<init>", "()V", "experience-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ElementMiddleVM extends BaseUiVM {
    static final /* synthetic */ KProperty[] $$delegatedProperties = null;
    private final p appointmentMessage$delegate;
    private final p changeHeightWhenEmpty$delegate;
    private final p dslLabelWidth$delegate;
    private final p isAppointmentShowing$delegate;
    private final p onFollowCanceled$delegate;
    private final p onFollowSuccess$delegate;
    private final p renderEmpty$delegate;
    private final p showProfileViewAnim$delegate;
    private final p userNameLayoutCurWidthPx$delegate;
    private final p userNameLayoutMaxWidthPx$delegate;
    private final p userNameLayoutRightMarginDP$delegate;
    private final p userNameViewVisibility$delegate;

    static {
        $$delegatedProperties = new KProperty[]{Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "userNameLayoutRightMarginDP", "getUserNameLayoutRightMarginDP()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "onFollowCanceled", "getOnFollowCanceled()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "onFollowSuccess", "getOnFollowSuccess()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "renderEmpty", "getRenderEmpty()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "showProfileViewAnim", "getShowProfileViewAnim()Lcom/bytedance/live/datacontext/IEventMember;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "userNameLayoutMaxWidthPx", "getUserNameLayoutMaxWidthPx()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "userNameLayoutCurWidthPx", "getUserNameLayoutCurWidthPx()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "dslLabelWidth", "getDslLabelWidth()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "appointmentMessage", "getAppointmentMessage()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "isAppointmentShowing", "isAppointmentShowing()Lcom/bytedance/live/datacontext/IMutableNonNull;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "userNameViewVisibility", "getUserNameViewVisibility()Lcom/bytedance/live/datacontext/IMutableNullable;", 0)), Reflection.property1(new PropertyReference1Impl(ElementMiddleVM.class, "changeHeightWhenEmpty", "getChangeHeightWhenEmpty()Lcom/bytedance/live/datacontext/IEventMember;", 0))};
    }

    public final n<ii> getAppointmentMessage() {
        return (n) this.appointmentMessage$delegate.a(this, $$delegatedProperties[8]);
    }

    public final k<Unit> getChangeHeightWhenEmpty() {
        return (k) this.changeHeightWhenEmpty$delegate.a(this, $$delegatedProperties[11]);
    }

    public final m<Integer> getDslLabelWidth() {
        return (m) this.dslLabelWidth$delegate.a(this, $$delegatedProperties[7]);
    }

    public final k<Unit> getOnFollowCanceled() {
        return (k) this.onFollowCanceled$delegate.a(this, $$delegatedProperties[1]);
    }

    public final k<Unit> getOnFollowSuccess() {
        return (k) this.onFollowSuccess$delegate.a(this, $$delegatedProperties[2]);
    }

    public final k<Unit> getRenderEmpty() {
        return (k) this.renderEmpty$delegate.a(this, $$delegatedProperties[3]);
    }

    public final k<y91.a> getShowProfileViewAnim() {
        return (k) this.showProfileViewAnim$delegate.a(this, $$delegatedProperties[4]);
    }

    public final m<Integer> getUserNameLayoutCurWidthPx() {
        return (m) this.userNameLayoutCurWidthPx$delegate.a(this, $$delegatedProperties[6]);
    }

    public final m<Integer> getUserNameLayoutMaxWidthPx() {
        return (m) this.userNameLayoutMaxWidthPx$delegate.a(this, $$delegatedProperties[5]);
    }

    public final m<Float> getUserNameLayoutRightMarginDP() {
        return (m) this.userNameLayoutRightMarginDP$delegate.a(this, $$delegatedProperties[0]);
    }

    public final n<Integer> getUserNameViewVisibility() {
        return (n) this.userNameViewVisibility$delegate.a(this, $$delegatedProperties[10]);
    }

    public final m<Boolean> isAppointmentShowing() {
        return (m) this.isAppointmentShowing$delegate.a(this, $$delegatedProperties[9]);
    }

    public ElementMiddleVM() {
        this.userNameLayoutRightMarginDP$delegate = q.a(this, Float.valueOf(0.0f), ElementMiddleVM$userNameLayoutRightMarginDP$2.INSTANCE);
        this.onFollowCanceled$delegate = e.a(this, ElementMiddleVM$onFollowCanceled$2.INSTANCE);
        this.onFollowSuccess$delegate = e.a(this, ElementMiddleVM$onFollowSuccess$2.INSTANCE);
        this.renderEmpty$delegate = e.a(this, ElementMiddleVM$renderEmpty$2.INSTANCE);
        this.showProfileViewAnim$delegate = e.a(this, ElementMiddleVM$showProfileViewAnim$2.INSTANCE);
        this.userNameLayoutMaxWidthPx$delegate = q.a(this, 0, ElementMiddleVM$userNameLayoutMaxWidthPx$2.INSTANCE);
        this.userNameLayoutCurWidthPx$delegate = q.a(this, -1, ElementMiddleVM$userNameLayoutCurWidthPx$2.INSTANCE);
        this.dslLabelWidth$delegate = q.d(this, -1);
        this.appointmentMessage$delegate = q.b(this, ElementMiddleVM$appointmentMessage$2.INSTANCE);
        this.isAppointmentShowing$delegate = q.a(this, Boolean.FALSE, AnonymousClass2.INSTANCE);
        this.userNameViewVisibility$delegate = q.b(this, ElementMiddleVM$userNameViewVisibility$2.INSTANCE);
        this.changeHeightWhenEmpty$delegate = e.a(this, ElementMiddleVM$changeHeightWhenEmpty$2.INSTANCE);
    }

    @Override // com.bytedance.android.live.room.navi.userinfo_p.viewmodel.base.BaseUiVM
    public void reduce(z91.a r100) {
        Intrinsics.checkNotNullParameter(r100, "action");
        if ((r100 instanceof b) == false) goto L11;
        if (((b) r100).f570981a == false) goto L7;
    L9:
        getUserNameLayoutRightMarginDP().setValue(Float.valueOf(4.0f));
        goto L11
    L7:
        if (wt2.e.a() == true) goto L9;
        getUserNameViewVisibility().setValue(0);
    L11:
        if ((r100 instanceof c) == false) goto L14;
        getOnFollowCanceled().post(Unit.INSTANCE);
    L14:
        if ((r100 instanceof d) == false) goto L17;
        getOnFollowSuccess().post(Unit.INSTANCE);
        return;
    }
}
