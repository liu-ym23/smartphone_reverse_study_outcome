package com.obric.Intelligentcall.activity;

import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.obric.network.request.intelligentvoice.SoundListGetResponseDetail;
import com.obric.oui.toast.OToast;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: IntelligentVoiceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", NotificationCompat.CATEGORY_ERROR, "", "invoke", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class IntelligentVoiceActivity$onDeleteClick$1$2 extends Lambda implements Function3<Integer, String, Throwable, Unit> {
    final /* synthetic */ SoundListGetResponseDetail $data;
    final /* synthetic */ IntelligentVoiceActivity this$0;

    public static /* synthetic */ void $r8$lambda$vm1OWt4tsUrYeeLoS42uzXQU3Wg(IntelligentVoiceActivity r0, SoundListGetResponseDetail r1, Integer r2, String r3, Throwable r4) {
        invoke$lambda$0(r0, r1, r2, r3, r4);
    }

    IntelligentVoiceActivity$onDeleteClick$1$2(IntelligentVoiceActivity r1, SoundListGetResponseDetail r2) {
        this.this$0 = r1;
        this.$data = r2;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer r1, String r2, Throwable r3) {
        invoke2(r1, r2, r3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Integer r8, final String r9, final Throwable r10) {
        Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_ERROR);
        final IntelligentVoiceActivity r0 = this.this$0;
        final SoundListGetResponseDetail r3 = this.$data;
        r0.runOnUiThread(new IntelligentVoiceActivity$onDeleteClick$1$2$$ExternalSyntheticLambda0(r0, r3, r8, r9, r10));
    }

    private static final void invoke$lambda$0(IntelligentVoiceActivity r6, SoundListGetResponseDetail r7, Integer r8, String r9, Throwable r10) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$data");
        Intrinsics.checkNotNullParameter(r10, "$err");
        IntelligentVoiceActivity.access$hideLoading(r6);
        StringBuilder r0 = new StringBuilder("deleteSound fail hasSpeakerId=");
        String r11 = r7.getSpeakerId();
        if (r11 != null) goto L5;
    L8:
        boolean r12 = true;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("IntelligentVoiceActivity", r0.append(!r12).append(", errCode=").append(r8).append(", errMsg=").append(r9).toString(), r10);
        String r2 = r6.getString(R.string.delete_fail_toast);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.delete_fail_toast)");
        OToast.Companion.show$default(OToast.Companion, r6, r2, 0, 4, null);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r12 = false;
        goto L9
    }
}
