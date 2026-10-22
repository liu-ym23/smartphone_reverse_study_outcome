package com.bytedance.android.livesdk.utils;

import androidx.lifecycle.LifecycleOwner;
import com.bytedance.android.livesdk.utils.b2;
import com.bytedance.android.livesdk.utils.g2;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u0003*\u0014\b\u0002\u0010\u0006*\u000e\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00000\u00052\u00020\u00072\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\b¨\u0006\t"}, d2 = {"Lcom/bytedance/android/livesdk/utils/IView;", "Lcom/bytedance/android/livesdk/utils/g2;", "STATE", "", "INTENT", "Lcom/bytedance/android/livesdk/utils/b2;", "M", "Landroidx/lifecycle/LifecycleOwner;", "Lcom/ss/android/ugc/aweme/compat/nullable/Observer;", "livedynamic_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface IView<STATE extends g2, INTENT, M extends b2<INTENT, STATE>> extends LifecycleOwner, Observer<STATE> {
}
