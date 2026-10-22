package bytedance.jvm.time;

import bytedance.jvm.time.zone.ZoneRules;
import bytedance.jvm.time.zone.ZoneRulesException;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.Objects;

/* JADX INFO: loaded from: classes28.dex */
final class ZoneRegion extends ZoneId {
    private static final long serialVersionUID = 8386373296231747096L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final transient ZoneRules f21518a;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f21519id;

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // bytedance.jvm.time.ZoneId
    public ZoneRules getRules() {
        ZoneRules r100 = this.f21518a;
        if (r100 == null) goto L6;
        return r100;
    L6:
        return bytedance.jvm.time.zone.a.a(this.f21519id, false);
    }

    @Override // bytedance.jvm.time.ZoneId
    public String getId() {
        return this.f21519id;
    }

    public static ZoneId readExternal(DataInput r100) throws IOException {
        return ZoneId.of(r100.readUTF(), false);
    }

    private void readObject(ObjectInputStream r100) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // bytedance.jvm.time.ZoneId
    public void write(DataOutput r100) throws IOException {
        r100.writeByte(7);
        writeExternal(r100);
    }

    public void writeExternal(DataOutput r100) throws IOException {
        r100.writeUTF(this.f21519id);
    }

    public ZoneRegion(String r100, ZoneRules r101) {
        this.f21519id = r100;
        this.f21518a = r101;
    }

    public static ZoneRegion ofId(String r100, boolean r101) {
        Objects.requireNonNull(r100, "zoneId");
        int r102 = r100.length();
        if (r102 < 2) goto L58;
        int r103 = 0;
    L5:
        if (r103 >= r102) goto L59;
        char r104 = r100.charAt(r103);
        if (r104 < 'a') goto L12;
        if (r104 > 'z') goto L12;
    L45:
        r103 = r103 + 1;
    L12:
        if (r104 < 'A') goto L17;
        if (r104 <= 'Z') goto L45;
    L17:
        if (r104 != '/') goto L21;
        if (r103 != 0) goto L45;
    L21:
        if (r104 < '0') goto L27;
        if (r104 > '9') goto L27;
        if (r103 != 0) goto L45;
    L27:
        if (r104 != '~') goto L31;
        if (r103 != 0) goto L45;
    L31:
        if (r104 != '.') goto L35;
        if (r103 != 0) goto L45;
    L35:
        if (r104 != '_') goto L39;
        if (r103 != 0) goto L45;
    L39:
        if (r104 != '+') goto L43;
        if (r103 != 0) goto L45;
    L43:
        if (r104 != '-') goto L47;
        if (r103 != 0) goto L45;
    L47:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(r100));
    L59:
        ZoneRules r105 = bytedance.jvm.time.zone.a.a(r100, true);     // Catch: ZoneRulesException -> L51
    L55:
        return new ZoneRegion(r100, r105);
    L51:
        e = move-exception;
        if (r101 == true) goto L56;
        r105 = null;
        goto L55
    L56:
        throw e;
    L58:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: ".concat(r100));
    }
}
