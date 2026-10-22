package cg6;

import android.content.Context;
import com.bytedance.live.bizlink.impl.platform.manager.MultiLinkGuestManager;
import dn0.b;
import hg6.h;
import io.reactivex.subjects.BehaviorSubject;
import vb6.g;

/* JADX INFO: loaded from: classes19.dex */
public interface a extends b {
    com.bytedance.live.bizlink.impl.platform.manager.a A0();

    h Fn();

    g O5();

    MultiLinkGuestManager W4();

    lb6.g W8();

    BehaviorSubject dj();

    jg6.a e5();

    hg6.g getRtcManager();

    void init(Context r100);

    void onResume();

    void release();
}
