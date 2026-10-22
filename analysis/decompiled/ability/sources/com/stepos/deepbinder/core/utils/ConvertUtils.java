package com.stepos.deepbinder.core.utils;

import androidx.autofill.HintConstants;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.agentbus.generated.AgentBusWakeContract;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0016\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\f\u001a\u00020\u000b2\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00012\b\u0010\n\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u0012\u001a\u00020\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/deepbinder/core/utils/ConvertUtils;", "", AppAgent.CONSTRUCT, "()V", "", HintConstants.AUTOFILL_HINT_NAME, "basicNameConvert", "(Ljava/lang/String;)Ljava/lang/String;", "typeName", TypedValues.AttributesType.S_TARGET, AgentBusWakeContract.EXTRA_SOURCE, "LC7/r;", "convertObjectToArray", "(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V", "", "", "longArray", "", "toPrimitive", "([Ljava/lang/Long;)[J", "deepbinder-core_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ConvertUtils {
    public static final ConvertUtils INSTANCE = new ConvertUtils();

    private ConvertUtils() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
     */
    /* JADX WARN: Removed duplicated region for block: B:44:0x006c A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String basicNameConvert(java.lang.String r1) {
        /*
            r0 = this;
            java.lang.String r0 = "name"
            kotlin.jvm.internal.k.f(r1, r0)
            int r0 = r1.hashCode()
            switch(r0) {
                case -2056817302: goto L61;
                case -527879800: goto L55;
                case -515992664: goto L49;
                case 155276373: goto L3d;
                case 344809556: goto L31;
                case 398507100: goto L25;
                case 398795216: goto L19;
                case 761287205: goto Ld;
                default: goto Lc;
            }
        Lc:
            goto L6c
        Ld:
            java.lang.String r0 = "java.lang.Double"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L16
            goto L6c
        L16:
            java.lang.String r0 = "double"
            return r0
        L19:
            java.lang.String r0 = "java.lang.Long"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L22
            goto L6c
        L22:
            java.lang.String r0 = "long"
            return r0
        L25:
            java.lang.String r0 = "java.lang.Byte"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L2e
            goto L6c
        L2e:
            java.lang.String r0 = "byte"
            return r0
        L31:
            java.lang.String r0 = "java.lang.Boolean"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L3a
            goto L6c
        L3a:
            java.lang.String r0 = "bool"
            return r0
        L3d:
            java.lang.String r0 = "java.lang.Character"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L46
            goto L6c
        L46:
            java.lang.String r0 = "char"
            return r0
        L49:
            java.lang.String r0 = "java.lang.Short"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L52
            goto L6c
        L52:
            java.lang.String r0 = "short"
            return r0
        L55:
            java.lang.String r0 = "java.lang.Float"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L5e
            goto L6c
        L5e:
            java.lang.String r0 = "float"
            return r0
        L61:
            java.lang.String r0 = "java.lang.Integer"
            boolean r0 = r1.equals(r0)
            if (r0 == 0) goto L6c
            java.lang.String r0 = "int"
            return r0
        L6c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.deepbinder.core.utils.ConvertUtils.basicNameConvert(java.lang.String):java.lang.String");
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final void convertObjectToArray(String typeName, Object target, Object source) {
        k.f(typeName, "typeName");
        k.f(target, "target");
        if (source == null) {
            return;
        }
        int iHashCode = typeName.hashCode();
        if (iHashCode != 2891) {
            if (iHashCode != 2904) {
                if (iHashCode != 2911) {
                    if (iHashCode != 2894) {
                        if (iHashCode != 2895) {
                            switch (iHashCode) {
                                case 2887:
                                    if (typeName.equals("[B")) {
                                        byte[] bArr = (byte[]) target;
                                        System.arraycopy((byte[]) source, 0, bArr, 0, bArr.length);
                                        return;
                                    }
                                    break;
                                case 2888:
                                    if (typeName.equals("[C")) {
                                        char[] cArr = (char[]) target;
                                        System.arraycopy((char[]) source, 0, cArr, 0, cArr.length);
                                        return;
                                    }
                                    break;
                                case 2889:
                                    if (typeName.equals("[D")) {
                                        double[] dArr = (double[]) target;
                                        System.arraycopy((double[]) source, 0, dArr, 0, dArr.length);
                                        return;
                                    }
                                    break;
                            }
                        } else if (typeName.equals("[J")) {
                            long[] jArr = (long[]) target;
                            System.arraycopy((long[]) source, 0, jArr, 0, jArr.length);
                            return;
                        }
                    } else if (typeName.equals("[I")) {
                        int[] iArr = (int[]) target;
                        System.arraycopy((int[]) source, 0, iArr, 0, iArr.length);
                        return;
                    }
                } else if (typeName.equals("[Z")) {
                    boolean[] zArr = (boolean[]) target;
                    System.arraycopy((boolean[]) source, 0, zArr, 0, zArr.length);
                    return;
                }
            } else if (typeName.equals("[S")) {
                short[] sArr = (short[]) target;
                System.arraycopy((short[]) source, 0, sArr, 0, sArr.length);
                return;
            }
        } else if (typeName.equals("[F")) {
            float[] fArr = (float[]) target;
            System.arraycopy((float[]) source, 0, fArr, 0, fArr.length);
            return;
        }
        Object[] objArr = (Object[]) target;
        System.arraycopy((Object[]) source, 0, objArr, 0, objArr.length);
    }

    public final long[] toPrimitive(Long[] longArray) {
        k.f(longArray, "longArray");
        int length = longArray.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = longArray[i].longValue();
        }
        return jArr;
    }
}
