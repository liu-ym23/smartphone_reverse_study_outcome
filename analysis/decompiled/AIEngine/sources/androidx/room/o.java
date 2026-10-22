package androidx.room;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.strictmode.Violation;
import com.google.android.material.datepicker.s;
import com.google.android.material.textfield.TextInputLayout;
import com.stepos.aiengine.R;
import com.stepos.aiengine.modelmanager.ModelManagerFragment;
import com.stepos.common.widget.ImageFontCompatView;
import com.stepos.common.widget.SearchEditText;
import com.stepos.core.common.telemetry.AiPowerEventBus;
import com.stepos.core.common.telemetry.AiPowerPerfRecord;
import com.stepos.core.model.manager.ModelCacheImpl;
import com.stepos.core.ota.confirmui.InProcessConfirmHost;
import com.stepos.core.ota.downloader.DownloadRequest;
import com.stepos.core.ota.downloader.Fetch2DownloadEngine;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.service.DeepBinderProvider;
import com.tonyodev.fetch2.Download;
import com.tonyodev.fetch2.Error;
import com.tonyodev.fetch2.Request;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import m0.f;
import z7.a;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final /* synthetic */ class o implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2578a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f2579b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2580c;

    public /* synthetic */ o(int i10, Object obj, Object obj2) {
        this.f2578a = i10;
        this.f2579b = obj;
        this.f2580c = obj2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        Pair pair;
        int i10 = this.f2578a;
        Object obj = this.f2580c;
        Object obj2 = this.f2579b;
        switch (i10) {
            case 0:
                Runnable command = (Runnable) obj2;
                p this$0 = (p) obj;
                kotlin.jvm.internal.g.f(command, "$command");
                kotlin.jvm.internal.g.f(this$0, "this$0");
                try {
                    command.run();
                    return;
                } finally {
                    this$0.b();
                }
            case 1:
                ((b.k) obj2).addObserverForBackInvoker((OnBackPressedDispatcher) obj);
                return;
            case 2:
                com.stepos.core.ota.downloader.a aVar = (com.stepos.core.ota.downloader.a) obj2;
                Fetch2DownloadEngine.enqueue$lambda$1((Fetch2DownloadEngine) aVar.f7575g, (zb.l) aVar.h, (DownloadRequest) aVar.f7576i, (Request) ((kotlin.Pair) obj).f9985a);
                return;
            case 3:
                ((com.stepos.core.ota.downloader.b) obj2).b((Error) obj);
                return;
            case 4:
                ((ya.d) obj2).j();
                return;
            case 5:
                com.google.android.material.datepicker.d dVar = (com.google.android.material.datepicker.d) obj2;
                TextInputLayout textInputLayout = dVar.f4954a;
                DateFormat dateFormat = dVar.f4956c;
                Context context = textInputLayout.getContext();
                textInputLayout.setError(context.getString(R.string.mtrl_picker_invalid_format) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_use), ((String) obj).replace(' ', (char) 160)) + "\n" + String.format(context.getString(R.string.mtrl_picker_invalid_format_example), dateFormat.format(new Date(s.f().getTimeInMillis())).replace(' ', (char) 160)));
                dVar.a();
                return;
            case 6:
                SearchEditText searchEditText = (SearchEditText) obj2;
                Context context2 = (Context) obj;
                int i11 = SearchEditText.f7027j;
                if (searchEditText.getParent() instanceof ViewGroup) {
                    ViewGroup viewGroup = (ViewGroup) searchEditText.getParent();
                    int[] iArr = new int[2];
                    searchEditText.getLocationInSurface(iArr);
                    int childCount = viewGroup.getChildCount();
                    for (int i12 = 0; i12 < childCount; i12++) {
                        View childAt = viewGroup.getChildAt(i12);
                        if (childAt instanceof ImageFontCompatView) {
                            int[] iArr2 = new int[2];
                            childAt.getLocationInSurface(iArr2);
                            if (iArr2[0] < (searchEditText.getWidth() / 2) + iArr[0]) {
                                pair = new Pair(Integer.valueOf(Math.abs(iArr2[0] - iArr[0])), Integer.valueOf(childAt.getWidth()));
                            }
                        }
                    }
                    pair = null;
                } else {
                    pair = null;
                }
                float f8 = context2.getResources().getConfiguration().fontScale;
                if (pair == null || f8 <= 1.0f) {
                    return;
                }
                searchEditText.setPadding(((Integer) pair.first).intValue() + ((Integer) pair.second).intValue() + context2.getResources().getDimensionPixelSize(R.dimen.mc_search_edit_margin_start), searchEditText.getPaddingTop(), searchEditText.getPaddingEnd(), searchEditText.getPaddingBottom());
                return;
            case 7:
                AiPowerEventBus.post$lambda$5((zb.l) obj2, (AiPowerPerfRecord) obj);
                return;
            case 8:
                ModelCacheImpl.clear$lambda$35((ArrayList) obj2, (ModelCacheImpl) obj);
                return;
            case 9:
                ((ModelCacheImpl) obj2).executeIdleRelease((String) obj);
                return;
            case 10:
                InProcessConfirmHost.access$rehostOn((InProcessConfirmHost) obj2, (Activity) obj);
                return;
            case 11:
                ((DeepBinderProvider) obj2).sendSyncCall((Call) obj);
                return;
            case 12:
                ModelManagerFragment.doPause$lambda$53((Context) obj2, (h6.s) obj);
                return;
            case 13:
                ModelManagerFragment.refreshRowsInPlace$lambda$29((Context) obj2, (ModelManagerFragment) obj);
                return;
            case 14:
                ((f.c) obj2).c((Typeface) obj);
                return;
            case 15:
                Violation violation = (Violation) obj;
                kotlin.jvm.internal.g.f(violation, "$violation");
                Log.e("FragmentStrictMode", "Policy violation with PENALTY_DEATH in " + ((String) obj2), violation);
                throw violation;
            case 16:
                o2.g gVar = (o2.g) obj;
                Iterator it = ((List) obj2).iterator();
                while (it.hasNext()) {
                    ((m2.a) it.next()).a(gVar.f10725e);
                }
                return;
            case 17:
                p7.a aVar2 = (p7.a) obj2;
                Context context3 = (Context) obj;
                String str = aVar2.f11457a;
                if (aVar2.f()) {
                    for (Intent intent : aVar2.d(context3)) {
                        try {
                            intent.setPackage("com.stepos.pushservice");
                            intent.setAction("com.stepos.cloud.pushservice.action.PUSH_MANAGER_SERVICE");
                            intent.putExtra("sdk_version_code", 5000007L);
                            context3.startService(intent);
                        } catch (Exception e10) {
                            s7.a.c(str, "sendRequestMessage error " + e10.getMessage());
                        }
                    }
                    return;
                }
                s7.a.c(str, "exec fail, mismatch condition");
                l.b bVarB = aVar2.b();
                if (bVarB != null) {
                    z7.a aVar3 = a.C0182a.f14277a;
                    String str2 = aVar2.f11458b;
                    String str3 = aVar2.f11459c;
                    String packageName = context3.getPackageName();
                    long jA = w7.a.a(context3);
                    String strE = aVar2.e();
                    String strA = aVar2.a(bVarB);
                    String str4 = aVar3.f14275a;
                    try {
                        Intent intent2 = new Intent();
                        intent2.addCategory(packageName);
                        intent2.setPackage(packageName);
                        intent2.setAction("com.stepos.push.intent.MESSAGE");
                        intent2.putExtra("method", strE);
                        intent2.putExtra("messageValue", strA);
                        intent2.putExtra("messageSign", z7.a.a(str2, str3, packageName, jA, strE));
                        context3.sendBroadcast(intent2);
                        s7.a.a(str4, "send callback message  packageName: " + packageName);
                        return;
                    } catch (Exception e11) {
                        s7.a.c(str4, "send callback message error " + e11.getMessage());
                        return;
                    }
                }
                return;
            default:
                String string = ((UUID) obj).toString();
                kotlin.jvm.internal.g.e(string, "id.toString()");
                androidx.work.impl.utils.a.a((androidx.work.impl.b) obj2, string);
                return;
        }
    }

    public /* synthetic */ o(ya.d dVar, int i10, Download download, eb.a aVar) {
        this.f2578a = 4;
        this.f2579b = dVar;
        this.f2580c = download;
    }
}
