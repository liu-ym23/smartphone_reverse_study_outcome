package org.threeten.bp;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.DataInput;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.Serializable;
import java.util.regex.Pattern;
import org.threeten.bp.jdk8.Jdk8Methods;
import org.threeten.bp.zone.ZoneRules;
import org.threeten.bp.zone.ZoneRulesException;
import org.threeten.bp.zone.ZoneRulesProvider;

/* JADX INFO: loaded from: classes5.dex */
final class ZoneRegion extends ZoneId implements Serializable {
    private static final Pattern PATTERN = null;
    private static final long serialVersionUID = 8386373296231747096L;
    private final String id;
    private final transient ZoneRules rules;

    static {
        PATTERN = Pattern.compile("[A-Za-z][A-Za-z0-9~/._+-]+");
    }

    private static ZoneRegion ofLenient(String r5) {
        if (r5.equals("Z") == true) goto L46;
        if (r5.startsWith("+") == true) goto L46;
        if (r5.startsWith("-") == true) goto L46;
        if (r5.equals("UTC") == true) goto L44;
        if (r5.equals("GMT") == true) goto L44;
        if (r5.equals("UT") == true) goto L44;
        if (r5.startsWith("UTC+") == false) goto L18;
    L37:
        ZoneOffset r1 = ZoneOffset.of(r5.substring(3));
        if (r1.getTotalSeconds() != 0) goto L42;
        return new ZoneRegion(r5.substring(0, 3), r1.getRules());
    L42:
        return new ZoneRegion(r5.substring(0, 3) + r1.getId(), r1.getRules());
    L18:
        if (r5.startsWith("GMT+") == true) goto L37;
        if (r5.startsWith("UTC-") == true) goto L37;
        if (r5.startsWith("GMT-") == true) goto L37;
        if (r5.startsWith("UT+") == false) goto L27;
    L31:
        ZoneOffset r6 = ZoneOffset.of(r5.substring(2));
        if (r6.getTotalSeconds() != 0) goto L36;
        return new ZoneRegion("UT", r6.getRules());
    L36:
        return new ZoneRegion("UT" + r6.getId(), r6.getRules());
    L27:
        if (r5.startsWith("UT-") == true) goto L31;
        return ofId(r5, false);
    L44:
        return new ZoneRegion(r5, ZoneOffset.UTC.getRules());
    L46:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + r5);
    }

    static ZoneRegion ofId(String r3, boolean r4) {
        Jdk8Methods.requireNonNull(r3, "zoneId");
        if (r3.length() < 2) goto L18;
        if (PATTERN.matcher(r3).matches() == false) goto L18;
        ZoneRules r0 = null;
        r0 = ZoneRulesProvider.getRules(r3, true);     // Catch: ZoneRulesException -> L9
    L15:
        return new ZoneRegion(r3, r0);
    L9:
        e = move-exception;
        if (r3.equals("GMT0") == false) goto L13;
        r0 = ZoneOffset.UTC.getRules();
        goto L15
    L13:
        if (r4 == false) goto L15;
        throw e;
    L18:
        throw new DateTimeException("Invalid ID for region-based ZoneId, invalid format: " + r3);
    }

    ZoneRegion(String r1, ZoneRules r2) {
        this.id = r1;
        this.rules = r2;
    }

    @Override // org.threeten.bp.ZoneId
    public String getId() {
        return this.id;
    }

    @Override // org.threeten.bp.ZoneId
    public ZoneRules getRules() {
        ZoneRules r0 = this.rules;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return ZoneRulesProvider.getRules(this.id, false);
    }

    private Object writeReplace() {
        return new Ser((byte) 7, this);
    }

    private Object readResolve() {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    @Override // org.threeten.bp.ZoneId
    void write(DataOutput r3) {
        DataOutput r4 = (DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.aiagent.plugin");
        r4.writeByte(7);
        writeExternal(r4);
    }

    void writeExternal(DataOutput r3) {
        ((DataOutput) ZeusTransformUtils.wrapperContextForParams(r3, DataOutput.class, "com.obric.aiagent.plugin")).writeUTF(this.id);
    }

    static ZoneId readExternal(DataInput r2) {
        return ofLenient(((DataInput) ZeusTransformUtils.wrapperContextForParams(r2, DataInput.class, "com.obric.aiagent.plugin")).readUTF());
    }
}
