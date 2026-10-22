package be0;

import com.bytedance.android.livesdkapi.depend.model.live.audio.IVoiceLiveTheme;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes46.dex */
public interface a {
    NextLiveData<IVoiceLiveTheme> a();

    NextLiveData<ArrayList<IVoiceLiveTheme>> b();

    NextLiveData<Integer> c();

    IVoiceLiveTheme d();

    NextLiveData<IVoiceLiveTheme> getCurrentTheme();
}
