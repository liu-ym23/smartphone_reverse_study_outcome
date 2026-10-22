package bh9;

import com.larus.audio.AudioServiceDelegate;
import com.larus.audio.bean.AudioUserConfig;
import com.larus.im.bean.bot.IconItem;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes30.dex */
public final class b {
    public static final a a() {
        AudioServiceDelegate r100 = AudioServiceDelegate.f288288a;
        AudioUserConfig r101 = r100.p().getValue();
        List<IconItem> r102 = null;
        if (r101 == null) goto L5;
        Map<String, List<String>> r103 = r101.getVoiceTalkList();
    L6:
        AudioUserConfig r104 = r100.p().getValue();
        if (r104 == null) goto L10;
        r102 = r104.getUgcVoiceIconList();
    L10:
        return new a(r103, r102);
    L5:
        r103 = null;
        goto L6
    }
}
