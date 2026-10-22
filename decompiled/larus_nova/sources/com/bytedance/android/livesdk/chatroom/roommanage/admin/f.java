package com.bytedance.android.livesdk.chatroom.roommanage.admin;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes7.dex */
public final class f<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PrompterDialog.b f111273a;

    public f(PrompterDialog.b r100) {
        this.f111273a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Long r101 = (Long) r100;
        PrompterDialog r102 = this.f111273a.f111228a;
        int r103 = PrompterDialog.f111216o;
        r102.T90();
    }
}
