package com.monitor.cloudmessage.callback;

import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public interface IAlogConsumer extends IConsumerResultCallback {
    List<String> handleAlogData(long r10, long r11, JSONObject r12);
}
