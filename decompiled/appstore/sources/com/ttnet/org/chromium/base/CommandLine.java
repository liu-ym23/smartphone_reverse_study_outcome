package com.ttnet.org.chromium.base;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes4.dex */
public abstract class CommandLine {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final AtomicReference f18242a = null;

    public interface Natives {
        void appendSwitch(String r10);

        void appendSwitchWithValue(String r10, String r11);

        void appendSwitchesAndArguments(String[] r10);

        String getSwitchValue(String r10);

        String[] getSwitchesFlattened();

        boolean hasSwitch(String r10);

        void init(String[] r10);

        void removeSwitch(String r10);
    }

    static {
        f18242a = new AtomicReference();
    }

    public static CommandLine a() {
        androidx.appcompat.widget.p.a(f18242a.get());
        return null;
    }
}
