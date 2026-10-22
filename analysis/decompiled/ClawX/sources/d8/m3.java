package d8;

import com.stepos.stepclaw.SecurePrefs;

/* compiled from: r8-map-id-ca86e8b578419e4708a9a7ee3f056b062b20ba338a8b13e201aefe3710dbf238 */
/* loaded from: classes.dex */
public final class m3 extends i3 {
    @Override // d8.i3
    public final void a(byte[] bArr) throws l4 {
        if (bArr.length > 0) {
            throw new l4("No value can be specified for no-default-alpn");
        }
    }

    @Override // d8.i3
    public final byte[] b() {
        return new byte[0];
    }

    @Override // d8.i3
    public final String toString() {
        return SecurePrefs.DEFAULT_LAST_DISCOVERED_STABLE_ID;
    }
}
