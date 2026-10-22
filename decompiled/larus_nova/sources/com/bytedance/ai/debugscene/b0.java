package com.bytedance.ai.debugscene;

import com.bytedance.ai.debug.NativeDebugPanelType;

/* JADX INFO: loaded from: classes43.dex */
public final class b0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f36313a = 0;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f36314a = null;

        static {
            int[] r100 = new int[NativeDebugPanelType.values().length];
            r100[NativeDebugPanelType.DEBUG_PANEL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L7
        L9:
            r100[NativeDebugPanelType.AGENT_TRACE.ordinal()] = 2;     // Catch: NoSuchFieldError -> L8
        L5:
            f36314a = r100;
        }
    }

    static {
    }
}
