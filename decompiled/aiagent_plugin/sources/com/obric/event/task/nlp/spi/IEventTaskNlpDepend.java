package com.obric.event.task.nlp.spi;

import android.content.Context;
import com.obric.event.task.nlp.api.i;
import com.obric.eventkit.task.model.ConditionTask;
import d.c.d;
import d.x;
import java.util.Map;

/* JADX INFO: compiled from: IEventTaskNlpDepend.kt */
/* JADX INFO: loaded from: classes4.dex */
public interface IEventTaskNlpDepend {
    Object appendTaskExtForCard(Map<String, String> r1, String r2, d<? super Map<String, String>> r3);

    Object checkQuery(String r1, String r2, String r3, d<? super com.obric.event.task.nlp.api.d<Boolean>> r4);

    int getMaxTaskCount();

    Object handleLocationConditionCandidate(String r1, i r2, Context r3, d<? super com.obric.event.task.nlp.api.d<i>> r4);

    Object showTaskCard(ConditionTask r1, String r2, d<? super x> r3);
}
