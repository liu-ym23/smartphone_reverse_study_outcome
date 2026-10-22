package com.obric.autogui.common.api.app.foundation;

import android.app.Application;
import android.content.Context;
import com.obric.autogui.common.api.app.HostAppInfo;
import d.c.d;
import d.x;

/* JADX INFO: compiled from: IAutoActionFoundationApi.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAutoActionFoundationApi {
    Context getContext();

    Context getContextOrNull();

    Application getHostApp();

    HostAppInfo getHostAppInfo();

    long getPluginVersionCode();

    FoundationStatus getStatus();

    Object suspendUntilCreated(d<? super x> r1);

    Object suspendUntilReady(d<? super x> r1);
}
