package ac8;

import com.larus.bmhome.actionbar.model.AgentMode;

/* JADX INFO: loaded from: classes25.dex */
public final class a {
    public static final boolean a(int r100, int r101, int r102, boolean r103) {
        Integer r104 = Integer.valueOf(r100);
        int r105 = r104.intValue();
        if (r105 >= 0) goto L5;
    L7:
        boolean r106 = false;
    L8:
        if (r106 == true) goto L11;
        r104 = null;
    L11:
        if (r104 == null) goto L14;
        r102 = r104.intValue();
    L14:
        if (r101 != AgentMode.CHAT.getValue()) goto L20;
        if ((r102 & 1) == 0) goto L18;
    L17:
        return true;
    L18:
        return false;
    L20:
        if (r101 == AgentMode.MOA.getValue()) goto L22;
        return r103;
    L22:
        if ((r102 & 2) == 0) goto L18;
    L5:
        if (r105 >= 4) goto L7;
        r106 = true;
        goto L8
    }
}
