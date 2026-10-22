package com.bytedance.android.sdk.bdticketguard.setting;

import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/json/JSONObject;", AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 1, 15})
final /* synthetic */ class BaseTicketGuardSettings$ticketSettingInt$1 extends FunctionReference implements Function0<JSONObject> {
    public BaseTicketGuardSettings$ticketSettingInt$1(BaseTicketGuardSettings r100) {
        super(0, r100);
    }

    @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
    public final String getName() {
        return "getLatestSettings";
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(BaseTicketGuardSettings.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    public final String getSignature() {
        return "getLatestSettings$bd_ticket_guard_api_release()Lorg/json/JSONObject;";
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final JSONObject invoke2() {
        return ((BaseTicketGuardSettings) this.receiver).a();
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ JSONObject invoke() {
        return invoke2();
    }
}
