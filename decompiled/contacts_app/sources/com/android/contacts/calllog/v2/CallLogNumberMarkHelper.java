package com.android.contacts.calllog.v2;

import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.android.contacts.activities.NumberMarkActivity;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.util.AnimationUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CallLogNumberMarkHelper.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\u0010\nJ \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0012\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0014\u001a\u00020\fJ\u0010\u0010\u0015\u001a\u00020\t2\b\u0010\u0013\u001a\u0004\u0018\u00010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogNumberMarkHelper;", "", "fragment", "Landroidx/fragment/app/Fragment;", "viewModel", "Lcom/android/contacts/calllog/v2/CallLogViewModel;", "onNumberMarkChanged", "Lkotlin/Function1;", "", "", "(Landroidx/fragment/app/Fragment;Lcom/android/contacts/calllog/v2/CallLogViewModel;Lkotlin/jvm/functions/Function1;)V", "handleActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "markNumber", "number", "isMarked", "unMarkNumber", "Companion", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class CallLogNumberMarkHelper {
    public static final Companion Companion = null;
    public static final int REQUEST_CODE_GET_NUMBER_MARK = 1009;
    private static final String TAG = "CallLogV2";
    private final Fragment fragment;
    private final Function1<String, Unit> onNumberMarkChanged;
    private final CallLogViewModel viewModel;

    /* JADX INFO: compiled from: CallLogNumberMarkHelper.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/android/contacts/calllog/v2/CallLogNumberMarkHelper$Companion;", "", "()V", "REQUEST_CODE_GET_NUMBER_MARK", "", "TAG", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CallLogNumberMarkHelper(Fragment r2, CallLogViewModel r3, Function1<? super String, Unit> r4) {
        Intrinsics.checkNotNullParameter(r2, "fragment");
        Intrinsics.checkNotNullParameter(r3, "viewModel");
        Intrinsics.checkNotNullParameter(r4, "onNumberMarkChanged");
        this.fragment = r2;
        this.viewModel = r3;
        this.onNumberMarkChanged = r4;
    }

    public static final /* synthetic */ Fragment access$getFragment$p(CallLogNumberMarkHelper r0) {
        return r0.fragment;
    }

    public static final /* synthetic */ Function1 access$getOnNumberMarkChanged$p(CallLogNumberMarkHelper r0) {
        return r0.onNumberMarkChanged;
    }

    public static final /* synthetic */ CallLogViewModel access$getViewModel$p(CallLogNumberMarkHelper r0) {
        return r0.viewModel;
    }

    public final void markNumber(String r5, boolean r6) {
        FragmentActivity r0 = this.fragment.getActivity();
        if (r0 != null) goto L5;
        return;
    L5:
        Intent r1 = new Intent(r0, NumberMarkActivity.class);
        r1.putExtra(NumberMarkActivity.EXTRA_PARAM_MARKED, r6);
        r1.putExtra(NumberMarkActivity.EXTRA_PARAM_NUMBER, r5);
        this.fragment.startActivityForResult(r1, 1009);
        AnimationUtil.switchActivityAnimation(r0, 1);
    }

    public final void unMarkNumber(final String r3) {
        NumberInfosManager.getInstance().clearMarkInfoAsync(r3, new C01691(this, r3));
    }

    public final boolean handleActivityResult(int r3, int r4, Intent r5) {
        if (r4 == (-1)) goto L5;
        return false;
    L5:
        if (r3 != 1009) goto L21;
        if (r5 == null) goto L22;
        int r6 = r5.getIntExtra("position", -1);
        final String r7 = r5.getStringExtra(NumberMarkActivity.EXTRA_PARAM_NUMBER);
        NumberInfosManager.NumberInfosListenerAdatper r0 = new CallLogNumberMarkHelper$handleActivityResult$listener$1(this, r7);
        if (NumberInfosManager.Classify.isValidIndex(r6) == false) goto L11;
        NumberInfosManager.getInstance().setMarkInfoAsync(r7, r6, r0);
        return true;
    L11:
        String r8 = r5.getStringExtra("flag");
        if (TextUtils.isEmpty(r8) == true) goto L14;
        NumberInfosManager.getInstance().setCustomMarkInfoAsync(r7, r8, r0);
        return true;
    L14:
        NumberInfosManager.getInstance().clearMarkInfoAsync(r7, new AnonymousClass1(this, r7));
        return true;
    L22:
        return false;
    L21:
        return false;
    }
}
