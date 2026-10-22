package com.stepos.alphame.utils;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class ReceiverUtils {
    @SuppressLint({"WrongConstant"})
    public static Intent registerReceiverExported(Context context, BroadcastReceiver broadcastReceiver, @NonNull IntentFilter intentFilter) {
        return context.registerReceiver(broadcastReceiver, intentFilter, 2);
    }
}
