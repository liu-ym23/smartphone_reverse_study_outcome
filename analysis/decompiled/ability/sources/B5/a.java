package B5;

import C4.f;
import F6.g;
import F9.C0234l;
import N9.j;
import S7.n;
import X6.e;
import Z7.t;
import a.AbstractC0291a;
import a7.AbstractC0308d;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.compose.ActivityResultRegistryKt;
import android.view.result.ActivityResult;
import android.view.result.ActivityResultCallback;
import android.view.viewmodel.compose.SavedStateHandleSaverKt;
import androidx.compose.runtime.State;
import androidx.core.graphics.Insets;
import androidx.core.os.CancellationSignal;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.inputmethod.InputConnectionCompat;
import androidx.core.view.inputmethod.InputContentInfoCompat;
import androidx.fragment.app.FragmentKt;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.SpecialEffectsController;
import androidx.preference.Preference;
import androidx.preference.PreferenceGroup;
import androidx.preference.PreferenceManager;
import com.google.gson.internal.ConstructorConstructor;
import com.google.gson.internal.ObjectConstructor;
import com.stepos.ability.voicewakeup.service.RebuildScheduler;
import com.stepos.ability.voicewakeup.setting.WakeupWordSelectionActivity;
import com.stepos.ability.voicewakeup.training.TrainingActivity;
import com.stepos.widget.list.StepOSListItem;
import com.stepos.widget.preference.StepOSRadioPreference;
import com.volcengine.tos.internal.TosResponse;
import com.volcengine.tos.model.object.CompleteMultipartUploadV2Input;
import com.volcengine.tos.model.object.CompleteMultipartUploadV2Output;
import com.zyql.common.utils.upload.MediaPermissionHelper;
import e3.InterfaceC1420i;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;
import kotlin.Result;
import kotlin.jvm.internal.k;
import u1.d;

/* loaded from: classes3.dex */
public final /* synthetic */ class a implements C5.a, ActivityResultCallback, OnApplyWindowInsetsListener, g, Preference.OnPreferenceClickListener, X6.a, InputConnectionCompat.OnCommitContentListener, FragmentResultListener, CancellationSignal.OnCancelListener, V7.a, V7.b, InterfaceC1420i, ObjectConstructor, RebuildScheduler.Cancellable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f193a;
    public final /* synthetic */ Object b;

    public /* synthetic */ a(C0234l c0234l, CompleteMultipartUploadV2Input completeMultipartUploadV2Input) {
        this.f193a = 7;
        this.b = completeMultipartUploadV2Input;
    }

    @Override // F6.g
    public void a(StepOSListItem stepOSListItem, boolean z10) {
        ((d) this.b).c = Boolean.valueOf(z10);
    }

    @Override // C5.a
    public void b() {
        Object objA;
        int i = this.f193a;
        Object obj = this.b;
        switch (i) {
            case 0:
                try {
                    objA = j.y((Context) obj);
                } catch (Throwable th) {
                    objA = kotlin.b.a(th);
                }
                if (objA instanceof Result.Failure) {
                    objA = null;
                }
                String str = (String) objA;
                if (str == null) {
                    str = "";
                }
                b.f194a = str;
                break;
            default:
                T3.b bVar = (T3.b) obj;
                bVar.b.execute(new T3.a(bVar, 1));
                break;
        }
    }

    @Override // X6.a
    public Object c(TosResponse tosResponse) throws IOException {
        boolean zY = AbstractC0291a.y(((CompleteMultipartUploadV2Input) this.b).getCallback());
        String strI = AbstractC0291a.I(tosResponse.d, "response body");
        CompleteMultipartUploadV2Output completeMultipartUploadV2Output = new CompleteMultipartUploadV2Output();
        if (zY) {
            completeMultipartUploadV2Output.setCallbackResult(strI);
            completeMultipartUploadV2Output.setEtag(tosResponse.c("ETag"));
            completeMultipartUploadV2Output.setLocation(tosResponse.c("Location"));
        } else {
            completeMultipartUploadV2Output = (CompleteMultipartUploadV2Output) AbstractC0308d.b(strI, new e());
        }
        return completeMultipartUploadV2Output.setRequestInfo(tosResponse.b()).setVersionID(tosResponse.c("X-Tos-Version-Id")).setHashCrc64ecma(tosResponse.c("x-tos-hash-crc64ecma"));
    }

    @Override // com.stepos.ability.voicewakeup.service.RebuildScheduler.Cancellable
    public void cancel() {
        ((ScheduledFuture) this.b).cancel(false);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        int i = this.f193a;
        Object obj = this.b;
        switch (i) {
            case 16:
                return ConstructorConstructor.lambda$newDefaultConstructor$9((Constructor) obj);
            default:
                return ConstructorConstructor.lambda$newUnsafeAllocator$19((Class) obj);
        }
    }

    @Override // V7.b
    public Object getValue(Object obj, t tVar) {
        return SavedStateHandleSaverKt.saveable$lambda$3$lambda$2(this.b, obj, tVar);
    }

    @Override // android.view.result.ActivityResultCallback
    public void onActivityResult(Object obj) {
        int i = this.f193a;
        Object obj2 = this.b;
        switch (i) {
            case 1:
                WakeupWordSelectionActivity wakeupWordSelectionActivity = (WakeupWordSelectionActivity) obj2;
                ActivityResult result = (ActivityResult) obj;
                int i6 = WakeupWordSelectionActivity.f;
                k.f(result, "result");
                Log.i("WakeupWordSelection", "training result code=" + result.getResultCode());
                if (!wakeupWordSelectionActivity.isFinishing() && !wakeupWordSelectionActivity.isDestroyed()) {
                    f fVar = wakeupWordSelectionActivity.b;
                    if (fVar == null || !fVar.a()) {
                        if (result.getResultCode() == -1 || (k.b((String) wakeupWordSelectionActivity.d.getF4884a(), "settings") && result.getResultCode() == 1)) {
                            wakeupWordSelectionActivity.setResult(result.getResultCode());
                            wakeupWordSelectionActivity.finish();
                            break;
                        }
                    }
                }
                break;
            case 8:
                ActivityResultRegistryKt.rememberLauncherForActivityResult$lambda$8$lambda$7$lambda$5((State) obj2, obj);
                break;
            default:
                MediaPermissionHelper.register$lambda$1((MediaPermissionHelper) obj2, (Map) obj);
                break;
        }
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public WindowInsetsCompat onApplyWindowInsets(View v10, WindowInsetsCompat insets) {
        TrainingActivity trainingActivity = (TrainingActivity) this.b;
        int i = TrainingActivity.f3357M;
        k.f(v10, "v");
        k.f(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        k.e(insets2, "getInsets(...)");
        v10.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        View view = trainingActivity.k;
        if (view == null) {
            k.n("flBottomGlowSlot");
            throw null;
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams != null) {
            int i6 = marginLayoutParams.bottomMargin;
            int i10 = -insets2.bottom;
            if (i6 != i10) {
                marginLayoutParams.bottomMargin = i10;
                View view2 = trainingActivity.k;
                if (view2 != null) {
                    view2.requestLayout();
                    return insets;
                }
                k.n("flBottomGlowSlot");
                throw null;
            }
        }
        return insets;
    }

    @Override // androidx.core.os.CancellationSignal.OnCancelListener
    public void onCancel() {
        SpecialEffectsController.Operation._init_$lambda$0((SpecialEffectsController.Operation) this.b);
    }

    @Override // androidx.core.view.inputmethod.InputConnectionCompat.OnCommitContentListener
    public boolean onCommitContent(InputContentInfoCompat inputContentInfoCompat, int i, Bundle bundle) {
        return InputConnectionCompat.lambda$createOnCommitContentListenerUsingPerformReceiveContent$0((View) this.b, inputContentInfoCompat, i, bundle);
    }

    @Override // androidx.fragment.app.FragmentResultListener
    public void onFragmentResult(String str, Bundle bundle) {
        FragmentKt.setFragmentResultListener$lambda$0((n) this.b, str, bundle);
    }

    @Override // androidx.preference.Preference.OnPreferenceClickListener
    public boolean onPreferenceClick(Preference it) {
        boolean zB;
        SharedPreferences sharedPreferences;
        SharedPreferences sharedPreferences2;
        SharedPreferences.Editor editorEdit;
        SharedPreferences.Editor editorPutString;
        StepOSRadioPreference stepOSRadioPreference = (StepOSRadioPreference) this.b;
        k.f(it, "it");
        String str = stepOSRadioPreference.d;
        String str2 = stepOSRadioPreference.c;
        if (str2 != null) {
            if (str2 == null) {
                zB = false;
            } else {
                PreferenceManager preferenceManager = stepOSRadioPreference.getPreferenceManager();
                zB = k.b((preferenceManager == null || (sharedPreferences = preferenceManager.getSharedPreferences()) == null) ? null : sharedPreferences.getString(str2, null), stepOSRadioPreference.d);
            }
            if (!zB && stepOSRadioPreference.callChangeListener(str)) {
                PreferenceManager preferenceManager2 = stepOSRadioPreference.getPreferenceManager();
                if (preferenceManager2 != null && (sharedPreferences2 = preferenceManager2.getSharedPreferences()) != null && (editorEdit = sharedPreferences2.edit()) != null && (editorPutString = editorEdit.putString(str2, str)) != null) {
                    editorPutString.apply();
                }
                PreferenceGroup parent = stepOSRadioPreference.getParent();
                if (parent == null) {
                    stepOSRadioPreference.notifyChanged();
                    return true;
                }
                int preferenceCount = parent.getPreferenceCount();
                for (int i = 0; i < preferenceCount; i++) {
                    Preference preference = parent.getPreference(i);
                    StepOSRadioPreference stepOSRadioPreference2 = preference instanceof StepOSRadioPreference ? (StepOSRadioPreference) preference : null;
                    if (stepOSRadioPreference2 != null) {
                        if (!k.b(stepOSRadioPreference2.c, str2)) {
                            stepOSRadioPreference2 = null;
                        }
                        if (stepOSRadioPreference2 != null) {
                            stepOSRadioPreference2.notifyChanged();
                        }
                    }
                }
            }
        }
        return true;
    }

    public /* synthetic */ a(Object obj, int i) {
        this.f193a = i;
        this.b = obj;
    }
}
