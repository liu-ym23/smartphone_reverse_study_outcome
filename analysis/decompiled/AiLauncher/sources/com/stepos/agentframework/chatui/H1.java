package com.stepos.agentframework.chatui;

import com.autonavi.aps.amapapi.config.Const;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\b\u001a\u00020\u00072\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0004\b\b\u0010\tJ#\u0010\r\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\n2\u0006\u0010\f\u001a\u00020\u0004¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentframework/chatui/H1;", "", "<init>", "()V", "", "index", "lastFinalTextIndex", "", Const.INTENT_KEY_PKGNAME, "(II)Z", "", "textIndices", "lastFoldableToolIndex", Const.INTENT_KEY_APIKEY, "(Ljava/util/List;I)I", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class H1 {
    public static final H1 INSTANCE = new H1();

    public final int a(List<Integer> textIndices, int lastFoldableToolIndex) {
        Integer numPrevious;
        kotlin.jvm.internal.p.i(textIndices, "textIndices");
        ListIterator<Integer> listIterator = textIndices.listIterator(textIndices.size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                numPrevious = null;
                break;
            }
            numPrevious = listIterator.previous();
            if (numPrevious.intValue() > lastFoldableToolIndex) {
                break;
            }
        }
        Integer num = numPrevious;
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }

    public final boolean b(int index, int lastFinalTextIndex) {
        return lastFinalTextIndex < 0 || index < lastFinalTextIndex;
    }
}
