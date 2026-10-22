package com.obric.Intelligentcall.activity;

import androidx.core.app.NotificationCompat;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.obric.network.request.intelligentvoice.IntelligentVoiceHelper;
import com.obric.network.request.intelligentvoice.SoundListGetResponseDetail;
import com.obric.oui.toast.OToast;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* JADX INFO: compiled from: IntelligentVoiceActivity.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\n¢\u0006\u0004\b\b\u0010\t"}, d2 = {"<anonymous>", "", "errCode", "", "errMsg", "", NotificationCompat.CATEGORY_ERROR, "", "invoke", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Throwable;)V"}, k = 3, mv = {1, 8, 0}, xi = 48)
final class IntelligentVoiceActivity$onEditClick$1$1$1$2 extends Lambda implements Function3<Integer, String, Throwable, Unit> {
    final /* synthetic */ SoundListGetResponseDetail $data;
    final /* synthetic */ String $text;
    final /* synthetic */ IntelligentVoiceActivity this$0;

    /* JADX INFO: compiled from: IntelligentVoiceActivity.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[IntelligentVoiceHelper.SoundCopyFailureType.values().length];
            r0[IntelligentVoiceHelper.SoundCopyFailureType.NAME_REVIEW_REJECTED.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[IntelligentVoiceHelper.SoundCopyFailureType.COPY_FAILED.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[IntelligentVoiceHelper.SoundCopyFailureType.VOICE_REVIEW_REJECTED.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[IntelligentVoiceHelper.SoundCopyFailureType.UNKNOWN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static /* synthetic */ void $r8$lambda$pY7O3hUTYk5x48b4SM2lWfwWMxM(IntelligentVoiceActivity r0, SoundListGetResponseDetail r1, String r2, Integer r3, String r4, Throwable r5) {
        invoke$lambda$0(r0, r1, r2, r3, r4, r5);
    }

    IntelligentVoiceActivity$onEditClick$1$1$1$2(IntelligentVoiceActivity r1, SoundListGetResponseDetail r2, String r3) {
        this.this$0 = r1;
        this.$data = r2;
        this.$text = r3;
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(Integer r1, String r2, Throwable r3) {
        invoke2(r1, r2, r3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(final Integer r9, final String r10, final Throwable r11) {
        Intrinsics.checkNotNullParameter(r11, NotificationCompat.CATEGORY_ERROR);
        final IntelligentVoiceActivity r0 = this.this$0;
        final SoundListGetResponseDetail r3 = this.$data;
        final String r4 = this.$text;
        r0.runOnUiThread(new IntelligentVoiceActivity$onEditClick$1$1$1$2$$ExternalSyntheticLambda0(r0, r3, r4, r9, r10, r11));
    }

    private static final void invoke$lambda$0(IntelligentVoiceActivity r6, SoundListGetResponseDetail r7, String r8, Integer r9, String r10, Throwable r11) {
        Intrinsics.checkNotNullParameter(r6, "this$0");
        Intrinsics.checkNotNullParameter(r7, "$data");
        Intrinsics.checkNotNullParameter(r8, "$text");
        Intrinsics.checkNotNullParameter(r11, "$err");
        IntelligentVoiceActivity.access$hideLoading(r6);
        StringBuilder r0 = new StringBuilder("renameSound fail hasSpeakerId=");
        String r12 = r7.getSpeakerId();
        if (r12 != null) goto L5;
    L8:
        boolean r13 = true;
    L9:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e("IntelligentVoiceActivity", r0.append(!r13).append(", newName=").append(r8).append(", errCode=").append(r9).append(", errMsg=").append(r10).toString(), r11);
        int r14 = WhenMappings.$EnumSwitchMapping$0[IntelligentVoiceHelper.INSTANCE.getSoundCopyFailureType(r9).ordinal()];
        if (r14 != 1) goto L12;
        String r15 = r6.getString(R.string.intelligent_sound_copy_name_review_rejected_toast);
    L22:
        String r2 = r15;
        Intrinsics.checkNotNullExpressionValue(r2, "when (IntelligentVoiceHe…                        }");
        OToast.Companion.show$default(OToast.Companion, r6, r2, 0, 4, null);
        return;
    L12:
        if (r14 != 2) goto L14;
    L20:
        r15 = r6.getString(R.string.edit_fail_toast);
        goto L22
    L14:
        if (r14 == 3) goto L20;
        if (r14 == 4) goto L20;
        throw new NoWhenBranchMatchedException();
    L5:
        if (r12.length() == 0) goto L8;
        r13 = false;
        goto L9
    }
}
