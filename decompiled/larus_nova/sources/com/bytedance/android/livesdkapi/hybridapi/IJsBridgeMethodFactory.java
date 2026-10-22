package com.bytedance.android.livesdkapi.hybridapi;

import androidx.fragment.app.DialogFragment;
import com.bytedance.ies.web.jsbridge2.g;
import kotlin.Deprecated;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Deprecated(message = "尽量不要在 browser 外面直接注册通用方法")
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0018\u0010\u0005\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/hybridapi/IJsBridgeMethodFactory;", "", "Landroidx/fragment/app/DialogFragment;", "dialogFragment", "Lcom/bytedance/ies/web/jsbridge2/g;", "provideCloseMethod", "livesdkapi-middleware_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IJsBridgeMethodFactory {
    g<?, ?> provideCloseMethod(DialogFragment r100);
}
