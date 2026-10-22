package com.obric.assistant.dm.api;

import com.obric.agent.dm.e;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.memorydata.sdk.entity.search.SearchResponse;
import d.h.a.m;
import d.h.a.q;
import d.h.a.s;
import d.x;
import java.util.List;

/* JADX INFO: compiled from: IDialogManagement.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface IDialogManagement {
    void endDialog();

    void getConfirmationPhraseForSecondTime(String r1, List<String> r2, s<? super Integer, ? super List<? extends AppEntity>, ? super String, ? super String, ? super String, x> r3);

    void getPopupContent(List<String> r1, String r2, String r3, q<? super Integer, ? super List<? extends AppEntity>, ? super String, x> r4);

    b handlePersonalContext(SearchResponse r1);

    boolean isActive();

    Object startDialog(e r1, s<? super Integer, ? super String, ? super Integer, ? super List<? extends AppEntity>, ? super String, x> r2, d.c.d<? super x> r3);

    Object userSelectByHand(int r1, m<? super Integer, ? super e, x> r2, d.c.d<? super x> r3);

    void userSelectWithAsr(String r1, q<? super Integer, ? super e, ? super String, x> r2);
}
