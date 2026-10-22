package org.threeten.bp;

import ig.d;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.c;

/* JADX INFO: loaded from: classes4.dex */
final class ZoneRegion extends ZoneId implements Serializable {
    private static final Pattern PATTERN = null;
    private static final long serialVersionUID = 8386373296231747096L;

    /* JADX INFO: renamed from: id, reason: collision with root package name */
    private final String f23084id;
    private final transient ZoneRules rules;

    static {
        PATTERN = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    }

    public ZoneRegion(String r10, ZoneRules r11) {
        this.f23084id = r10;
        this.rules = r11;
    }

    public static ZoneRegion ofId(String r10, boolean r11) {
        d.h(r10, "zoneId");
        if (r10.length() < 2) goto L19;
        if (PATTERN.matcher(r10).matches() == false) goto L19;
        ZoneRules r12 = c.c(r10, true);     // Catch: ZoneRulesException -> L9
    L16:
        return new ZoneRegion(r10, r12);
    L9:
        e = move-exception;
        if (r10.equals("GMT0") == false) goto L13;
        r12 = ZoneOffset.UTC.getRules();
        goto L16
    L13:
        if (r11 == true) goto L17;
        r12 = null;
        goto L16
    L17:
        throw e;
    L19:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + r10);
    }

    private static ZoneRegion ofLenient(String r10) {
        if (r10.equals("Z") == true) goto L46;
        if (r10.startsWith("+") == true) goto L46;
        if (r10.startsWith("-") == true) goto L46;
        if (r10.equals("UTC") == true) goto L44;
        if (r10.equals("GMT") == true) goto L44;
        if (r10.equals("UT") == true) goto L44;
        if (r10.startsWith("UTC+") == false) goto L18;
    L37:
        ZoneOffset r11 = ZoneOffset.of(r10.substring(3));
        if (r11.getTotalSeconds() != 0) goto L42;
        return new ZoneRegion(r10.substring(0, 3), r11.getRules());
    L42:
        return new ZoneRegion(r10.substring(0, 3) + r11.getId(), r11.getRules());
    L18:
        if (r10.startsWith("GMT+") == true) goto L37;
        if (r10.startsWith("UTC-") == true) goto L37;
        if (r10.startsWith("GMT-") == true) goto L37;
        if (r10.startsWith("UT+") == false) goto L27;
    L31:
        ZoneOffset r12 = ZoneOffset.of(r10.substring(2));
        if (r12.getTotalSeconds() != 0) goto L36;
        return new ZoneRegion("UT", r12.getRules());
    L36:
        return new ZoneRegion("UT" + r12.getId(), r12.getRules());
    L27:
        if (r10.startsWith("UT-") == true) goto L31;
        return ofId(r10, false);
    L44:
        return new ZoneRegion(r10, ZoneOffset.UTC.getRules());
    L46:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + r10);
    }

    public static ZoneId readExternal(DataInput r10) throws IOException {
        return ofLenient(r10.readUTF());
    }

    private Object readResolve() throws ObjectStreamException {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.f23084id;
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        ZoneRules r10 = this.rules;
        if (r10 == null) goto L6;
        return r10;
    L6:
        return c.c(this.f23084id, false);
    }

    @Override // org.threeten.bp.ZoneId
    public void write(DataOutput r10) throws IOException {
        r10.writeByte(7);
        writeExternal(r10);
    }

    public void writeExternal(DataOutput r10) throws IOException {
        r10.writeUTF(this.f23084id);
    }
}
