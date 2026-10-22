package com.obric.autogui.common.api.assistant;

import android.content.Context;

/* JADX INFO: compiled from: IAssistCardResourceProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IAssistCardResourceProvider {
    int getBackgroundRes(AssistCardBgResType r1, boolean r2);

    int getIconRes(AssistCardIconResType r1, boolean r2);

    int getIdRes(AssistCardIdResType r1);

    int getLayoutRes();

    int getResId(Context r1, String r2, String r3);
}
