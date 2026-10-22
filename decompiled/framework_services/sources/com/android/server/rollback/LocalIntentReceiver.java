package com.android.server.rollback;

import android.content.IIntentSender;
import android.content.Intent;
import android.content.IntentSender;
import java.util.function.Consumer;

/* JADX INFO: loaded from: classes3.dex */
class LocalIntentReceiver {
    final Consumer<Intent> mConsumer;
    private IIntentSender.Stub mLocalSender;

    LocalIntentReceiver(Consumer<Intent> consumer) {
        this.mLocalSender = new AnonymousClass1(this);
        this.mConsumer = consumer;
    }

    IntentSender getIntentSender() {
        return new IntentSender(this.mLocalSender);
    }
}
