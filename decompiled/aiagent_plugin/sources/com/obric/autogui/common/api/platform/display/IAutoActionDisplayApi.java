package com.obric.autogui.common.api.platform.display;

import android.content.Context;
import com.obric.aiagent.product.platform.api.app.ObricAutoVirtualDisplayRecordSetListener;
import com.obric.autogui.common.api.platform.display.vd.VDConfig;
import d.c.d;
import java.util.Collection;

/* JADX INFO: compiled from: IAutoActionDisplayApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionDisplayApi {
    public static final Companion Companion = null;
    public static final int RECORD_SET_CLOSE_REASON_DISPLAY_REMOVED = 2;
    public static final int RECORD_SET_CLOSE_REASON_ENDED = 1;
    public static final int RECORD_SET_CLOSE_REASON_REPLACED = 4;

    /* JADX INFO: compiled from: IAutoActionDisplayApi.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = null;
        public static final int RECORD_SET_CLOSE_REASON_DISPLAY_REMOVED = 2;
        public static final int RECORD_SET_CLOSE_REASON_ENDED = 1;
        public static final int RECORD_SET_CLOSE_REASON_REPLACED = 4;

        static {
            $$INSTANCE = new Companion();
        }

        private Companion() {
        }
    }

    static {
        Companion = Companion.$$INSTANCE;
    }

    boolean addVirtualDisplayRecordPackages(long r1, Collection<String> r3);

    long beginVirtualDisplayRecordSet(int r1, int r2, ObricAutoVirtualDisplayRecordSetListener r3);

    boolean bringTaskToFront(Context r1, int r2);

    void clearGloballyDisabledPackages(Context r1);

    Object createVD(Context r1, VDConfig r2, d<? super DisplayAccessor> r3);

    void endVirtualDisplayRecordSet(long r1);

    DisplayAccessor getMDAccess(Context r1);

    int getMainDisplayId();

    void setGloballyDisabledPackages(Context r1, Collection<String> r2);

    boolean supportsVirtualDisplayRecordSet();
}
