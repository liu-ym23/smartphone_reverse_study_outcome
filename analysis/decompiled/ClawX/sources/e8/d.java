package e8;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.win32.W32APIOptions;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public interface d extends Library {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f2400a = 0;

    static {
        if (Native.load("IPHlpAPI", d.class, W32APIOptions.ASCII_OPTIONS) != null) {
            throw new ClassCastException();
        }
    }
}
