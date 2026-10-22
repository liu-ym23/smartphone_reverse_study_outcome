package com.bes.sdk.message;

import java.util.LinkedList;

/* JADX INFO: loaded from: classes39.dex */
public class EQStatusMessage extends BaseMessage {
    private LinkedList<EQSettings> eqList;

    @Override // com.bes.sdk.message.BaseMessage
    public /* bridge */ /* synthetic */ Object getMsgContent() {
        return getMsgContent();
    }

    @Override // com.bes.sdk.message.BaseMessage
    public LinkedList<EQSettings> getMsgContent() {
        return this.eqList;
    }

    public EQStatusMessage(LinkedList<EQSettings> r100) {
        this.eqList = r100;
    }
}
