package com.android.server.devicepolicy;

import android.app.admin.PolicyValue;
import android.util.IndentingPrintWriter;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.utils.Slogf;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Objects;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class PolicyState<V> {
    private static final String TAG = "PolicyState";
    private static final String TAG_ADMIN_POLICY_ENTRY = "admin-policy-entry";
    private static final String TAG_ENFORCING_ADMIN_ENTRY = "enforcing-admin-entry";
    private static final String TAG_POLICY_VALUE_ENTRY = "policy-value-entry";
    private static final String TAG_RESOLVED_VALUE_ENTRY = "resolved-value-entry";
    private PolicyValue<V> mCurrentResolvedPolicy;
    private final LinkedHashMap<EnforcingAdmin, PolicyValue<V>> mPoliciesSetByAdmins;
    private final PolicyDefinition<V> mPolicyDefinition;

    PolicyState(PolicyDefinition<V> policyDefinition) {
        this.mPoliciesSetByAdmins = new LinkedHashMap();
        policyDefinition.getClass();
        this.mPolicyDefinition = policyDefinition;
    }

    private PolicyState(PolicyDefinition<V> policyDefinition, LinkedHashMap<EnforcingAdmin, PolicyValue<V>> policiesSetByAdmins, PolicyValue<V> currentEnforcedPolicy) {
        this.mPoliciesSetByAdmins = new LinkedHashMap();
        policyDefinition.getClass();
        policiesSetByAdmins.getClass();
        this.mPolicyDefinition = policyDefinition;
        this.mPoliciesSetByAdmins.putAll(policiesSetByAdmins);
        this.mCurrentResolvedPolicy = currentEnforcedPolicy;
    }

    boolean addPolicy(EnforcingAdmin admin, PolicyValue<V> policy) {
        admin.getClass();
        this.mPoliciesSetByAdmins.remove(admin);
        this.mPoliciesSetByAdmins.put(admin, policy);
        return resolvePolicy();
    }

    boolean addPolicy(EnforcingAdmin admin, PolicyValue<V> policy, LinkedHashMap<EnforcingAdmin, PolicyValue<V>> globalPoliciesSetByAdmins) {
        LinkedHashMap<EnforcingAdmin, PolicyValue<V>> r0 = this.mPoliciesSetByAdmins;
        admin.getClass();
        r0.put(admin, policy);
        return resolvePolicy(globalPoliciesSetByAdmins);
    }

    boolean removePolicy(EnforcingAdmin admin) {
        admin.getClass();
        if (this.mPoliciesSetByAdmins.remove(admin) != null) goto L7;
        return false;
    L7:
        return resolvePolicy();
    }

    boolean removePolicy(EnforcingAdmin admin, LinkedHashMap<EnforcingAdmin, PolicyValue<V>> globalPoliciesSetByAdmins) {
        admin.getClass();
        if (this.mPoliciesSetByAdmins.remove(admin) != null) goto L7;
        return false;
    L7:
        return resolvePolicy(globalPoliciesSetByAdmins);
    }

    boolean resolvePolicy(LinkedHashMap<EnforcingAdmin, PolicyValue<V>> globalPoliciesSetByAdmins) {
        if (this.mPolicyDefinition.isNonCoexistablePolicy() == false) goto L6;
        return false;
    L6:
        LinkedHashMap<EnforcingAdmin, PolicyValue<V>> mergedPolicies = new LinkedHashMap(globalPoliciesSetByAdmins);
        mergedPolicies.putAll(this.mPoliciesSetByAdmins);
        PolicyValue<V> resolvedPolicy = this.mPolicyDefinition.resolvePolicy(mergedPolicies);
        boolean policyChanged = !Objects.equals(resolvedPolicy, this.mCurrentResolvedPolicy);
        this.mCurrentResolvedPolicy = resolvedPolicy;
        return policyChanged;
    }

    LinkedHashMap<EnforcingAdmin, PolicyValue<V>> getPoliciesSetByAdmins() {
        return new LinkedHashMap(this.mPoliciesSetByAdmins);
    }

    private boolean resolvePolicy() {
        if (this.mPolicyDefinition.isNonCoexistablePolicy() == false) goto L6;
        return false;
    L6:
        PolicyValue<V> resolvedPolicy = this.mPolicyDefinition.resolvePolicy(this.mPoliciesSetByAdmins);
        boolean policyChanged = !Objects.equals(resolvedPolicy, this.mCurrentResolvedPolicy);
        this.mCurrentResolvedPolicy = resolvedPolicy;
        return policyChanged;
    }

    PolicyValue<V> getCurrentResolvedPolicy() {
        return this.mCurrentResolvedPolicy;
    }

    android.app.admin.PolicyState<V> getParcelablePolicyState() {
        LinkedHashMap<android.app.admin.EnforcingAdmin, PolicyValue<V>> adminPolicies = new LinkedHashMap();
        Iterator<EnforcingAdmin> r1 = this.mPoliciesSetByAdmins.keySet().iterator();
    L4:
        if (r1.hasNext() == false) goto L7;
        EnforcingAdmin admin = r1.next();
        adminPolicies.put(admin.getParcelableAdmin(), this.mPoliciesSetByAdmins.get(admin));
        goto L4
    L7:
        return new android.app.admin.PolicyState(adminPolicies, this.mCurrentResolvedPolicy, this.mPolicyDefinition.getResolutionMechanism().mo3501getParcelableResolutionMechanism());
    }

    public String toString() {
        return "\nPolicyKey - " + this.mPolicyDefinition.getPolicyKey() + "\nmPolicyDefinition= \n\t" + this.mPolicyDefinition + "\nmPoliciesSetByAdmins= \n\t" + this.mPoliciesSetByAdmins + ",\nmCurrentResolvedPolicy= \n\t" + this.mCurrentResolvedPolicy + " }";
    }

    public void dump(IndentingPrintWriter pw) {
        pw.println(this.mPolicyDefinition.getPolicyKey());
        pw.increaseIndent();
        pw.println("Per-admin Policy:");
        pw.increaseIndent();
        if (this.mPoliciesSetByAdmins.size() != 0) goto L5;
        pw.println("null");
    L9:
        pw.decreaseIndent();
        pw.printf("Resolved Policy (%s):\n", new Object[]{this.mPolicyDefinition.getResolutionMechanism().getClass().getSimpleName()});
        pw.increaseIndent();
        pw.println(this.mCurrentResolvedPolicy);
        pw.decreaseIndent();
        pw.decreaseIndent();
        return;
    L5:
        Iterator<EnforcingAdmin> r0 = this.mPoliciesSetByAdmins.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L9;
        EnforcingAdmin admin = r0.next();
        pw.println(admin);
        pw.increaseIndent();
        pw.println(this.mPoliciesSetByAdmins.get(admin));
        pw.decreaseIndent();
        goto L7
    }

    void saveToXml(TypedXmlSerializer r8) throws IOException {
        if (this.mCurrentResolvedPolicy == null) goto L5;
        r8.startTag(null, TAG_RESOLVED_VALUE_ENTRY);
        this.mPolicyDefinition.savePolicyValueToXml(r8, (V) this.mCurrentResolvedPolicy.getValue());
        r8.endTag(null, TAG_RESOLVED_VALUE_ENTRY);
    L5:
        Iterator<EnforcingAdmin> r0 = this.mPoliciesSetByAdmins.keySet().iterator();
    L7:
        if (r0.hasNext() == false) goto L12;
        EnforcingAdmin r2 = r0.next();
        r8.startTag(null, TAG_ADMIN_POLICY_ENTRY);
        if (this.mPoliciesSetByAdmins.get(r2) == null) goto L11;
        r8.startTag(null, TAG_POLICY_VALUE_ENTRY);
        this.mPolicyDefinition.savePolicyValueToXml(r8, (V) this.mPoliciesSetByAdmins.get(r2).getValue());
        r8.endTag(null, TAG_POLICY_VALUE_ENTRY);
    L11:
        r8.startTag(null, TAG_ENFORCING_ADMIN_ENTRY);
        r2.saveToXml(r8);
        r8.endTag(null, TAG_ENFORCING_ADMIN_ENTRY);
        r8.endTag(null, TAG_ADMIN_POLICY_ENTRY);
        goto L7
    }

    static <V> PolicyState<V> readFromXml(PolicyDefinition<V> policyDefinition, TypedXmlPullParser parser) throws IOException, XmlPullParserException {
        PolicyValue<V> currentResolvedPolicy = null;
        LinkedHashMap<EnforcingAdmin, PolicyValue<V>> policiesSetByAdmins = new LinkedHashMap();
        int outerDepth = parser.getDepth();
    L4:
        if (XmlUtils.nextElementWithin(parser, outerDepth) == false) goto L62;
        String tag = parser.getName();
        switch(tag.hashCode()) {
            case 695389653: goto L12;
            case 829992641: goto L9;
            default: goto L14;
        };
    L14:
        byte r5 = -1;
    L16:
        switch(r5) {
            case 0: goto L23;
            case 1: goto L18;
            default: goto L17;
        };
    L18:
        if (policyDefinition == null) goto L19;
        currentResolvedPolicy = policyDefinition.readPolicyValueFromXml(parser);
        if (currentResolvedPolicy != null) goto L4;
        StringBuilder r6 = new StringBuilder();
        r6.append("Error Parsing TAG_RESOLVED_VALUE_ENTRY for ");
        r6.append("policy with definition " + policyDefinition);
        r6.append(", currentResolvedPolicy is null");
        Slogf.wtf(TAG, r6.toString());
        goto L4
    L19:
        Slogf.wtf(TAG, "Error Parsing TAG_RESOLVED_VALUE_ENTRY, policyDefinition is null");
        goto L4
    L23:
        PolicyValue<V> value = null;
        EnforcingAdmin admin = null;
        int adminPolicyDepth = parser.getDepth();
    L25:
        if (XmlUtils.nextElementWithin(parser, adminPolicyDepth) == false) goto L45;
        String adminPolicyTag = parser.getName();
        switch(adminPolicyTag.hashCode()) {
            case -1365069882: goto L33;
            case -698838789: goto L30;
            default: goto L35;
        };
    L35:
        byte r13 = -1;
    L36:
        switch(r13) {
            case 0: goto L41;
            case 1: goto L38;
            default: goto L25;
        };
    L38:
        value = policyDefinition.readPolicyValueFromXml(parser);
        if (value != null) goto L25;
        Slogf.wtf(TAG, "Error Parsing TAG_POLICY_VALUE_ENTRY, PolicyValue is null");
        goto L25
    L41:
        admin = EnforcingAdmin.readFromXml(parser);
        if (admin != null) goto L25;
        Slogf.wtf(TAG, "Error Parsing TAG_ENFORCING_ADMIN_ENTRY, EnforcingAdmin is null");
        goto L25
    L30:
        if (adminPolicyTag.equals(TAG_POLICY_VALUE_ENTRY) == false) goto L95;
        r13 = 1;
        goto L36
    L95:
        r13 = -1;
        goto L36
    L33:
        if (adminPolicyTag.equals(TAG_ENFORCING_ADMIN_ENTRY) == false) goto L96;
        r13 = 0;
        goto L36
    L96:
        r13 = -1;
        goto L36
    L45:
        if (admin == null) goto L48;
        if (value == null) goto L48;
        policiesSetByAdmins.put(admin, value);
    L48:
        StringBuilder r7 = new StringBuilder();
        r7.append("Error Parsing TAG_ADMIN_POLICY_ENTRY for ");
        if (policyDefinition != null) goto L51;
        String r8 = "unknown policy";
    L52:
        r7.append(r8);
        r7.append(", EnforcingAdmin is: ");
        PolicyValue<V> r9 = "null";
        if (admin != null) goto L55;
        Object r10 = "null";
    L56:
        r7.append(r10);
        r7.append(", value is : ");
        if (value == null) goto L60;
        r9 = value;
    L60:
        r7.append(r9);
        Slogf.wtf(TAG, r7.toString());
        goto L4
    L55:
        r10 = admin;
        goto L56
    L51:
        r8 = "policy with definition " + policyDefinition;
        goto L52
    L17:
        Slogf.wtf(TAG, "Unknown tag: " + tag);
        goto L4
    L9:
        if (tag.equals(TAG_RESOLVED_VALUE_ENTRY) == false) goto L97;
        r5 = 1;
        goto L16
    L97:
        r5 = -1;
        goto L16
    L12:
        if (tag.equals(TAG_ADMIN_POLICY_ENTRY) == false) goto L98;
        r5 = 0;
        goto L16
    L98:
        r5 = -1;
        goto L16
    L62:
        if (policyDefinition != null) goto L64;
        Slogf.wtf(TAG, "Error parsing policyState, policyDefinition is null");
        return null;
    L64:
        return new PolicyState(policyDefinition, policiesSetByAdmins, currentResolvedPolicy);
    }

    PolicyDefinition<V> getPolicyDefinition() {
        return this.mPolicyDefinition;
    }
}
