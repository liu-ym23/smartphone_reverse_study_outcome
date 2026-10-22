package com.android.server.appop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DiscreteOpsMigrationHelper {
    public static /* synthetic */ void $r8$lambda$19tSOZDLMLzIL5IqAUQI2hUj4lI(Integer r0, String r1, Integer r2, List r3, String r4, DiscreteOpsXmlRegistry.DiscreteDeviceOp r5) {
        lambda$getSqlDiscreteOps$1(r0, r1, r2, r3, r4, r5);
    }

    /* JADX INFO: renamed from: $r8$lambda$RDOCngC1y_PoXkxyzmIO0-OO97w, reason: not valid java name */
    public static /* synthetic */ void m1766$r8$lambda$RDOCngC1y_PoXkxyzmIO0OO97w(List r0, Integer r1, DiscreteOpsXmlRegistry.DiscreteUidOps r2) {
        lambda$getSqlDiscreteOps$4(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$X2z3KoEf2FtHQFrKHbHiBpbkK7w(Integer r0, String r1, List r2, Integer r3, DiscreteOpsXmlRegistry.DiscreteOp r4) {
        lambda$getSqlDiscreteOps$2(r0, r1, r2, r3, r4);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZfpeygonAq8KDE2KwS-9vHEvN8c, reason: not valid java name */
    public static /* synthetic */ void m1767$r8$lambda$ZfpeygonAq8KDE2KwS9vHEvN8c(Integer r0, String r1, String r2, Integer r3, List r4, String r5, List r6) {
        lambda$getSqlDiscreteOps$0(r0, r1, r2, r3, r4, r5, r6);
    }

    /* JADX INFO: renamed from: $r8$lambda$y8jVtD60r1BH-ULLfLoyYubJERU, reason: not valid java name */
    public static /* synthetic */ void m1768$r8$lambda$y8jVtD60r1BHULLfLoyYubJERU(Integer r0, List r1, String r2, DiscreteOpsXmlRegistry.DiscretePackageOps r3) {
        lambda$getSqlDiscreteOps$3(r0, r1, r2, r3);
    }

    public DiscreteOpsMigrationHelper() {
    }

    static void migrateDiscreteOpsToSqlite(DiscreteOpsXmlRegistry xmlRegistry, DiscreteOpsSqlRegistry sqlRegistry) {
        DiscreteOpsXmlRegistry.DiscreteOps xmlOps = xmlRegistry.getAllDiscreteOps();
        List<DiscreteOpsSqlRegistry.DiscreteOp> discreteOps = getSqlDiscreteOps(xmlOps);
        sqlRegistry.migrateXmlData(discreteOps, xmlOps.mChainIdOffset);
        xmlRegistry.deleteDiscreteOpsDir();
    }

    static void migrateDiscreteOpsToXml(DiscreteOpsSqlRegistry sqlRegistry, DiscreteOpsXmlRegistry xmlRegistry) {
        List<DiscreteOpsSqlRegistry.DiscreteOp> sqlOps = sqlRegistry.getAllDiscreteOps();
        List<DiscreteOpsSqlRegistry.DiscreteOp> filteredList = new ArrayList();
        Iterator<DiscreteOpsSqlRegistry.DiscreteOp> r2 = sqlOps.iterator();
    L4:
        if (r2.hasNext() == false) goto L9;
        DiscreteOpsSqlRegistry.DiscreteOp opEvent = r2.next();
        if (DiscreteOpsRegistry.isDiscreteOp(opEvent.getOpCode(), opEvent.getOpFlags()) == false) goto L4;
        filteredList.add(opEvent);
        goto L4
    L9:
        DiscreteOpsXmlRegistry.DiscreteOps xmlOps = getXmlDiscreteOps(filteredList);
        xmlRegistry.migrateSqliteData(xmlOps);
        sqlRegistry.deleteDatabase();
    }

    private static DiscreteOpsXmlRegistry.DiscreteOps getXmlDiscreteOps(List<DiscreteOpsSqlRegistry.DiscreteOp> discreteOps) {
        DiscreteOpsXmlRegistry.DiscreteOps xmlOps = new DiscreteOpsXmlRegistry.DiscreteOps(0);
        if (discreteOps.isEmpty() == false) goto L5;
        return xmlOps;
    L5:
        Iterator<DiscreteOpsSqlRegistry.DiscreteOp> r0 = discreteOps.iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        DiscreteOpsSqlRegistry.DiscreteOp discreteOp = r0.next();
        Iterator<DiscreteOpsSqlRegistry.DiscreteOp> r16 = r0;
        xmlOps.addDiscreteAccess(discreteOp.getOpCode(), discreteOp.getUid(), discreteOp.getPackageName(), discreteOp.getDeviceId(), discreteOp.getAttributionTag(), discreteOp.getOpFlags(), discreteOp.getUidState(), discreteOp.getAccessTime(), discreteOp.getDuration(), discreteOp.getAttributionFlags(), (int) discreteOp.getChainId());
        r0 = r16;
        goto L7
    L9:
        return xmlOps;
    }

    private static List<DiscreteOpsSqlRegistry.DiscreteOp> getSqlDiscreteOps(DiscreteOpsXmlRegistry.DiscreteOps discreteOps) {
        final List<DiscreteOpsSqlRegistry.DiscreteOp> opEvents = new ArrayList();
        if (discreteOps.isEmpty() == false) goto L5;
        return opEvents;
    L5:
        discreteOps.mUids.forEach(new DiscreteOpsMigrationHelper$$ExternalSyntheticLambda4(opEvents));
        return opEvents;
    }

    private static /* synthetic */ void lambda$getSqlDiscreteOps$4(final List opEvents, final Integer uid, DiscreteOpsXmlRegistry.DiscreteUidOps discreteUidOps) {
        discreteUidOps.mPackages.forEach(new DiscreteOpsMigrationHelper$$ExternalSyntheticLambda2(uid, opEvents));
    }

    private static /* synthetic */ void lambda$getSqlDiscreteOps$3(final Integer uid, final List opEvents, final String packageName, DiscreteOpsXmlRegistry.DiscretePackageOps packageOps) {
        packageOps.mPackageOps.forEach(new DiscreteOpsMigrationHelper$$ExternalSyntheticLambda0(uid, packageName, opEvents));
    }

    private static /* synthetic */ void lambda$getSqlDiscreteOps$2(final Integer uid, final String packageName, final List opEvents, final Integer opcode, DiscreteOpsXmlRegistry.DiscreteOp ops) {
        ops.mDeviceAttributedOps.forEach(new DiscreteOpsMigrationHelper$$ExternalSyntheticLambda3(uid, packageName, opcode, opEvents));
    }

    private static /* synthetic */ void lambda$getSqlDiscreteOps$1(final Integer uid, final String packageName, final Integer opcode, final List opEvents, final String deviceId, DiscreteOpsXmlRegistry.DiscreteDeviceOp deviceOps) {
        deviceOps.mAttributedOps.forEach(new DiscreteOpsMigrationHelper$$ExternalSyntheticLambda1(uid, packageName, deviceId, opcode, opEvents));
    }

    private static /* synthetic */ void lambda$getSqlDiscreteOps$0(Integer uid, String packageName, String deviceId, Integer opcode, List opEvents, String tag, List attributedOps) {
        Iterator r0 = attributedOps.iterator();
    L4:
        if (r0.hasNext() == false) goto L7;
        DiscreteOpsXmlRegistry.DiscreteOpEvent attributedOp = (DiscreteOpsXmlRegistry.DiscreteOpEvent) r0.next();
        DiscreteOpsSqlRegistry.DiscreteOp opModel = new DiscreteOpsSqlRegistry.DiscreteOp(uid.intValue(), packageName, tag, deviceId, opcode.intValue(), attributedOp.mOpFlag, attributedOp.mAttributionFlags, attributedOp.mUidState, attributedOp.mAttributionChainId, attributedOp.mNoteTime, attributedOp.mNoteDuration);
        opEvents.add(opModel);
        goto L4
    }
}
