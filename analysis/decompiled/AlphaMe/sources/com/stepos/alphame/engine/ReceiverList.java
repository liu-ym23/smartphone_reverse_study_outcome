package com.stepos.alphame.engine;

import android.os.IBinder;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ReceiverList {
    public ArrayList<String> actions;
    public IBinder client;
    public int receiver;

    public ReceiverList(IBinder iBinder, ArrayList<String> arrayList, int i4) {
        this.client = iBinder;
        this.actions = arrayList;
        this.receiver = i4;
    }
}
