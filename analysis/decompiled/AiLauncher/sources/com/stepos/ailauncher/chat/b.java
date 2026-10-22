package com.stepos.ailauncher.chat;

import com.autonavi.aps.amapapi.config.Const;
import h8.C4148a;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0012\u0018\u0000 \f2\u00020\u0001:\u0001\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0005\u0010\u0003J\u000f\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0003J\u000f\u0010\u0007\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\u0003J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000b¨\u0006\r"}, d2 = {"Lcom/stepos/ailauncher/chat/b;", "Lcom/stepos/ailauncher/chat/f;", "<init>", "()V", "LY8/t;", Const.INTENT_KEY_APIKEY, "c", Const.INTENT_KEY_PKGNAME, "", "hasException", Const.INTENT_KEY_UMID, "(Z)V", "Companion", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class b implements f {
    private static final String TAG = "PickFileMediator";

    @Override // com.stepos.ailauncher.chat.f
    public void a() {
        C4148a.k(TAG, "onResultStart", false, 4, null);
    }

    @Override // com.stepos.ailauncher.chat.f
    public void b() {
        C4148a.k(TAG, "onResultUriEmpty", false, 4, null);
    }

    @Override // com.stepos.ailauncher.chat.f
    public void c() {
        C4148a.k(TAG, "onResultCancel", false, 4, null);
    }

    @Override // com.stepos.ailauncher.chat.f
    public void d(boolean hasException) {
        C4148a.k(TAG, "onHandleDoneFinish", false, 4, null);
    }
}
