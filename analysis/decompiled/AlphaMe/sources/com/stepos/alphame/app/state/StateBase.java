package com.stepos.alphame.app.state;

import java.util.List;

/* loaded from: classes.dex */
public abstract class StateBase {
    protected static boolean DEBUG = true;

    public abstract int getState(String str);

    public abstract List<String> getWorkDetail();

    public abstract List<String> getWorkList();

    public abstract int isWorking(long j4);

    public abstract void pause();

    public abstract void run();

    public abstract void startCheck(List<String> list);
}
