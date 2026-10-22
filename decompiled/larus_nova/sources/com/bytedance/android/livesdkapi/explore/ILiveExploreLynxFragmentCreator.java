package com.bytedance.android.livesdkapi.explore;

import android.content.Context;
import androidx.fragment.app.Fragment;
import com.ss.android.lark.utils.statistics.PerfLog;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0014\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\u0006H&J\b\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\u0003H&¨\u0006\r"}, d2 = {"Lcom/bytedance/android/livesdkapi/explore/ILiveExploreLynxFragmentCreator;", "", "callPauseLiveBridge", "", "callPlayLiveBridge", "createLiveLynxFragment", "Landroidx/fragment/app/Fragment;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "createLiveWebFragment", "isTop", "", "release", "livesdkapi_saasRelease"}, k = 1, mv = {1, 4, 3})
public interface ILiveExploreLynxFragmentCreator {
    void callPauseLiveBridge();

    void callPlayLiveBridge();

    Fragment createLiveLynxFragment(Context r100);

    Fragment createLiveWebFragment();

    boolean isTop();

    void release();
}
