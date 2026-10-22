package com.bytedance.android.livesdk.chatroom.viewmodule.toolbar;

import com.bytedance.android.live.core.utils.FileUtils;
import io.reactivex.SingleEmitter;
import io.reactivex.SingleOnSubscribe;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class j0<T> implements SingleOnSubscribe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ List f116359a;

    public j0(List r100) {
        this.f116359a = r100;
    }

    @Override // io.reactivex.SingleOnSubscribe
    public final void subscribe(SingleEmitter<Boolean> r100) {
        Intrinsics.checkNotNullParameter(r100, "emitter");
        Iterator<T> r101 = this.f116359a.iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        FileUtils.removeFile((String) r101.next());
        goto L4
    L6:
        r100.onSuccess(Boolean.TRUE);
    }
}
