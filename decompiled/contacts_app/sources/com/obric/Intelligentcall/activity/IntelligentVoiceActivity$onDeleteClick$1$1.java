package com.obric.Intelligentcall.activity;

import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.obric.network.request.intelligentvoice.SoundListGetResponseDetail;
import com.obric.oui.toast.OToast;
import com.obric.settings.SettingsProviderHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

/* JADX INFO: compiled from: IntelligentVoiceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lorg/json/JSONObject;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class IntelligentVoiceActivity$onDeleteClick$1$1 extends Lambda implements Function1<JSONObject, Unit> {
    final /* synthetic */ SoundListGetResponseDetail $data;
    final /* synthetic */ int $position;
    final /* synthetic */ IntelligentVoiceActivity this$0;

    /* JADX INFO: renamed from: $r8$lambda$VzBBoaafeaVwL-9WMp9UEHqW4kY, reason: not valid java name */
    public static /* synthetic */ void m306$r8$lambda$VzBBoaafeaVwL9WMp9UEHqW4kY(IntelligentVoiceActivity r0, SoundListGetResponseDetail r1, int r2, JSONObject r3) {
        invoke$lambda$0(r0, r1, r2, r3);
    }

    IntelligentVoiceActivity$onDeleteClick$1$1(IntelligentVoiceActivity r1, SoundListGetResponseDetail r2, int r3) {
        this.this$0 = r1;
        this.$data = r2;
        this.$position = r3;
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(JSONObject r1) {
        invoke2(r1);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final JSONObject r4) {
        final IntelligentVoiceActivity r0 = this.this$0;
        final SoundListGetResponseDetail r1 = this.$data;
        final int r3 = this.$position;
        r0.runOnUiThread(new IntelligentVoiceActivity$onDeleteClick$1$1$$ExternalSyntheticLambda0(r0, r1, r3, r4));
    }

    private static final void invoke$lambda$0(IntelligentVoiceActivity r9, SoundListGetResponseDetail r10, int r11, JSONObject r12) {
        Intrinsics.checkNotNullParameter(r9, "this$0");
        Intrinsics.checkNotNullParameter(r10, "$data");
        IntelligentVoiceActivity r1 = r9;
        if (Intrinsics.areEqual(SettingsProviderHelper.INSTANCE.getIntelligentVoiceCheckId(r1), r10.getSpeakerId()) == false) goto L5;
        SettingsProviderHelper.INSTANCE.setIntelligentVoiceCheckId(r1, "defaultSound");
    L5:
        IntelligentVoiceActivity.access$hideLoading(r9);
        String r5 = r9.getString(R.string.delete_success_toast);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.delete_success_toast)");
        OToast.Companion.show$default(OToast.Companion, r9, r5, 0, 4, null);
        r9.getCustomSoundList().remove(r10);
        IntelligentVoiceActivity.access$updateSoundList(r9, r11 - 1);
        StringBuilder r13 = new StringBuilder("deleteSound success hasSpeakerId=");
        String r14 = r10.getSpeakerId();
        if (r14 != null) goto L8;
    L11:
        boolean r15 = true;
    L12:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i("IntelligentVoiceActivity", r13.append(!r15).append(", response=").append(r12).toString());
        return;
    L8:
        if (r14.length() == 0) goto L11;
        r15 = false;
        goto L12
    }
}
