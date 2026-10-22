package com.android.server.devicepolicy;

import android.app.admin.Authority;
import android.app.admin.DeviceAdminAuthority;
import android.app.admin.DpcAuthority;
import android.app.admin.RoleAuthority;
import android.app.admin.UnknownAuthority;
import android.content.ComponentName;
import android.os.UserHandle;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.role.RoleManagerLocal;
import com.android.server.LocalManagerRegistry;
import com.android.server.utils.Slogf;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class EnforcingAdmin {
    private static final String ATTR_AUTHORITIES = "authorities";
    private static final String ATTR_AUTHORITIES_SEPARATOR = ";";
    private static final String ATTR_CLASS_NAME = "class-name";
    private static final String ATTR_IS_ROLE = "is-role";
    private static final String ATTR_IS_SYSTEM = "is-system";
    private static final String ATTR_PACKAGE_NAME = "package-name";
    private static final String ATTR_SYSTEM_ENTITY = "system-entity";
    private static final String ATTR_USER_ID = "user-id";
    static final String DEFAULT_AUTHORITY = "default";
    static final String DEVICE_ADMIN_AUTHORITY = "device_admin";
    static final String DPC_AUTHORITY = "enterprise";
    static final String ROLE_AUTHORITY_PREFIX = "role:";
    static final String SYSTEM_AUTHORITY_PREFIX = "system:";
    static final String TAG = "EnforcingAdmin";
    private Set<String> mAuthorities;
    private final ComponentName mComponentName;
    private final boolean mIsRoleAuthority;
    private final boolean mIsSystemAuthority;
    private final String mPackageName;
    private final String mSystemEntity;
    private final int mUserId;

    static EnforcingAdmin createEnforcingAdmin(String packageName, int userId) {
        packageName.getClass();
        return new EnforcingAdmin(packageName, userId);
    }

    static EnforcingAdmin createEnterpriseEnforcingAdmin(ComponentName componentName, int userId) {
        componentName.getClass();
        return new EnforcingAdmin(componentName.getPackageName(), componentName, Set.of(DPC_AUTHORITY), userId);
    }

    static EnforcingAdmin createDeviceAdminEnforcingAdmin(ComponentName componentName, int userId) {
        componentName.getClass();
        return new EnforcingAdmin(componentName.getPackageName(), componentName, Set.of(DEVICE_ADMIN_AUTHORITY), userId);
    }

    static EnforcingAdmin createSystemEnforcingAdmin(String systemEntity) {
        systemEntity.getClass();
        return new EnforcingAdmin(systemEntity);
    }

    static EnforcingAdmin createEnforcingAdmin(android.app.admin.EnforcingAdmin admin) {
        admin.getClass();
        RoleAuthority r0 = admin.getAuthority();
        new HashSet();
        if (DpcAuthority.DPC_AUTHORITY.equals(r0) == false) goto L7;
        return new EnforcingAdmin(admin.getPackageName(), admin.getComponentName(), Set.of(DPC_AUTHORITY), admin.getUserHandle().getIdentifier());
    L7:
        if (DeviceAdminAuthority.DEVICE_ADMIN_AUTHORITY.equals(r0) == false) goto L11;
        return new EnforcingAdmin(admin.getPackageName(), admin.getComponentName(), Set.of(DEVICE_ADMIN_AUTHORITY), admin.getUserHandle().getIdentifier());
    L11:
        if ((r0 instanceof RoleAuthority) == false) goto L15;
        return new EnforcingAdmin(admin.getPackageName(), admin.getComponentName(), Set.of(DEVICE_ADMIN_AUTHORITY), admin.getUserHandle().getIdentifier(), true);
    L15:
        return new EnforcingAdmin(admin.getPackageName(), admin.getComponentName(), Set.of(), admin.getUserHandle().getIdentifier());
    }

    static String getRoleAuthorityOf(String roleName) {
        return ROLE_AUTHORITY_PREFIX + roleName;
    }

    static Authority getParcelableAuthority(String authority) {
        if (authority == null) goto L21;
        if (authority.isEmpty() == true) goto L21;
        if (DPC_AUTHORITY.equals(authority) == false) goto L11;
        return DpcAuthority.DPC_AUTHORITY;
    L11:
        if (DEVICE_ADMIN_AUTHORITY.equals(authority) == false) goto L15;
        return DeviceAdminAuthority.DEVICE_ADMIN_AUTHORITY;
    L15:
        if (authority.startsWith(ROLE_AUTHORITY_PREFIX) == false) goto L19;
        String role = authority.substring(ROLE_AUTHORITY_PREFIX.length());
        return new RoleAuthority(Set.of(role));
    L19:
        return UnknownAuthority.UNKNOWN_AUTHORITY;
    L21:
        return UnknownAuthority.UNKNOWN_AUTHORITY;
    }

    private EnforcingAdmin(String packageName, ComponentName componentName, Set<String> authorities, int userId) {
        packageName.getClass();
        authorities.getClass();
        this.mIsRoleAuthority = false;
        this.mIsSystemAuthority = false;
        this.mPackageName = packageName;
        this.mSystemEntity = null;
        this.mComponentName = componentName;
        this.mAuthorities = new HashSet(authorities);
        this.mUserId = userId;
    }

    private EnforcingAdmin(String packageName, int userId) {
        packageName.getClass();
        this.mIsRoleAuthority = true;
        this.mIsSystemAuthority = false;
        this.mPackageName = packageName;
        this.mSystemEntity = null;
        this.mUserId = userId;
        this.mComponentName = null;
        this.mAuthorities = null;
    }

    private EnforcingAdmin(String systemEntity) {
        systemEntity.getClass();
        this.mIsSystemAuthority = true;
        this.mIsRoleAuthority = false;
        this.mPackageName = "";
        this.mSystemEntity = systemEntity;
        this.mUserId = 0;
        this.mComponentName = null;
        this.mAuthorities = getSystemAuthority(systemEntity);
    }

    private EnforcingAdmin(String packageName, ComponentName componentName, Set<String> authorities, int userId, boolean isRoleAuthority) {
        packageName.getClass();
        authorities.getClass();
        this.mIsRoleAuthority = isRoleAuthority;
        this.mIsSystemAuthority = false;
        this.mPackageName = packageName;
        this.mSystemEntity = null;
        this.mComponentName = componentName;
        this.mAuthorities = new HashSet(authorities);
        this.mUserId = userId;
    }

    private static Set<String> getRoleAuthoritiesOrDefault(String packageName, int userId) {
        Set<String> roles = getRoles(packageName, userId);
        Set<String> authorities = new HashSet();
        Iterator<String> r2 = roles.iterator();
    L4:
        if (r2.hasNext() == false) goto L7;
        String role = r2.next();
        authorities.add(ROLE_AUTHORITY_PREFIX + role);
        goto L4
    L7:
        if (authorities.isEmpty() == false) goto L10;
        return Set.of("default");
    L10:
        return authorities;
    }

    private static Set<String> getSystemAuthority(String systemEntity) {
        Set<String> authorities = new HashSet();
        authorities.add(SYSTEM_AUTHORITY_PREFIX + systemEntity);
        return authorities;
    }

    private static Set<String> getRoles(String packageName, int userId) {
        RoleManagerLocal roleManagerLocal = (RoleManagerLocal) LocalManagerRegistry.getManager(RoleManagerLocal.class);
        Set<String> roles = new HashSet();
        Map<String, Set<String>> rolesAndHolders = roleManagerLocal.getRolesAndHolders(userId);
        Iterator<String> r3 = rolesAndHolders.keySet().iterator();
    L4:
        if (r3.hasNext() == false) goto L9;
        String role = r3.next();
        if (rolesAndHolders.get(role).contains(packageName) == false) goto L4;
        roles.add(role);
        goto L4
    L9:
        return roles;
    }

    private Set<String> getAuthorities() {
        if (this.mAuthorities != null) goto L8;
        if (this.mIsRoleAuthority == false) goto L8;
        this.mAuthorities = getRoleAuthoritiesOrDefault(this.mPackageName, this.mUserId);
    L8:
        return this.mAuthorities;
    }

    void reloadRoleAuthorities() {
        if (this.mIsRoleAuthority == false) goto L6;
        this.mAuthorities = getRoleAuthoritiesOrDefault(this.mPackageName, this.mUserId);
        return;
    }

    boolean hasAuthority(String authority) {
        return getAuthorities().contains(authority);
    }

    boolean isSystemAuthority() {
        return this.mIsSystemAuthority;
    }

    String getPackageName() {
        return this.mPackageName;
    }

    int getUserId() {
        return this.mUserId;
    }

    ComponentName getComponentName() {
        return this.mComponentName;
    }

    android.app.admin.EnforcingAdmin getParcelableAdmin() {
        if (this.mIsRoleAuthority == false) goto L10;
        Set<String> roles = getRoles(this.mPackageName, this.mUserId);
        if (roles.isEmpty() == false) goto L7;
        UnknownAuthority r1 = UnknownAuthority.UNKNOWN_AUTHORITY;
    L20:
        return new android.app.admin.EnforcingAdmin(this.mPackageName, r1, UserHandle.of(this.mUserId), this.mComponentName);
    L7:
        r1 = new RoleAuthority(roles);
        goto L20
    L10:
        if (this.mAuthorities.contains(DPC_AUTHORITY) == false) goto L13;
        r1 = DpcAuthority.DPC_AUTHORITY;
        goto L20
    L13:
        if (this.mAuthorities.contains(DEVICE_ADMIN_AUTHORITY) == false) goto L16;
        r1 = DeviceAdminAuthority.DEVICE_ADMIN_AUTHORITY;
        goto L20
    L16:
        if (this.mIsSystemAuthority == false) goto L18;
        r1 = new UnknownAuthority(this.mSystemEntity);
        goto L20
    L18:
        r1 = UnknownAuthority.UNKNOWN_AUTHORITY;
        goto L20
    }

    public boolean equals(Object o) {
        if (this != o) goto L6;
        return true;
    L6:
        if (o != null) goto L8;
    L25:
        return false;
    L8:
        if (getClass() != o.getClass()) goto L25;
        EnforcingAdmin other = (EnforcingAdmin) o;
        if (Objects.equals(this.mPackageName, other.mPackageName) == false) goto L24;
        if (Objects.equals(this.mSystemEntity, other.mSystemEntity) == false) goto L24;
        if (Objects.equals(this.mComponentName, other.mComponentName) == false) goto L24;
        if (Objects.equals(Boolean.valueOf(this.mIsRoleAuthority), Boolean.valueOf(other.mIsRoleAuthority)) == false) goto L24;
        if (this.mIsSystemAuthority != other.mIsSystemAuthority) goto L24;
        if (hasMatchingAuthorities(this, other) == false) goto L24;
        return true;
    L24:
        return false;
    }

    private static boolean hasMatchingAuthorities(EnforcingAdmin admin1, EnforcingAdmin admin2) {
        if (admin1.mIsRoleAuthority == false) goto L9;
        if (admin2.mIsRoleAuthority == false) goto L9;
        return true;
    L9:
        return admin1.getAuthorities().equals(admin2.getAuthorities());
    }

    public int hashCode() {
        if (this.mIsRoleAuthority == false) goto L7;
        return Objects.hash(new Object[]{this.mPackageName, Integer.valueOf(this.mUserId)});
    L7:
        if (this.mIsSystemAuthority == false) goto L11;
        return Objects.hash(new Object[]{this.mSystemEntity});
    L11:
        if (this.mComponentName != null) goto L13;
        Object r0 = this.mPackageName;
    L15:
        return Objects.hash(new Object[]{r0, Integer.valueOf(this.mUserId), getAuthorities()});
    L13:
        r0 = this.mComponentName;
        goto L15
    }

    void saveToXml(TypedXmlSerializer serializer) throws IOException {
        serializer.attribute(null, ATTR_PACKAGE_NAME, this.mPackageName);
        serializer.attributeBoolean(null, ATTR_IS_ROLE, this.mIsRoleAuthority);
        serializer.attributeBoolean(null, ATTR_IS_SYSTEM, this.mIsSystemAuthority);
        serializer.attributeInt(null, ATTR_USER_ID, this.mUserId);
        if (this.mIsSystemAuthority == false) goto L6;
        serializer.attribute(null, ATTR_SYSTEM_ENTITY, this.mSystemEntity);
    L6:
        if (this.mIsRoleAuthority == false) goto L8;
        return;
    L8:
        if (this.mIsSystemAuthority == false) goto L10;
        return;
    L10:
        if (this.mComponentName == null) goto L12;
        serializer.attribute(null, ATTR_CLASS_NAME, this.mComponentName.getClassName());
    L12:
        serializer.attribute(null, ATTR_AUTHORITIES, String.join(ATTR_AUTHORITIES_SEPARATOR, getAuthorities()));
    }

    static EnforcingAdmin readFromXml(TypedXmlPullParser parser) throws XmlPullParserException {
        ComponentName componentName = null;
        String packageName = parser.getAttributeValue(null, ATTR_PACKAGE_NAME);
        String systemEntity = parser.getAttributeValue(null, ATTR_SYSTEM_ENTITY);
        boolean isRoleAuthority = parser.getAttributeBoolean(null, ATTR_IS_ROLE);
        boolean isSystemAuthority = parser.getAttributeBoolean(null, ATTR_IS_SYSTEM, false);
        String authoritiesStr = parser.getAttributeValue(null, ATTR_AUTHORITIES);
        int userId = parser.getAttributeInt(null, ATTR_USER_ID);
        if (isRoleAuthority == false) goto L9;
        if (packageName != null) goto L8;
        Slogf.wtf(TAG, "Error parsing EnforcingAdmin with RoleAuthority, packageName is null.");
        return null;
    L8:
        return new EnforcingAdmin(packageName, userId);
    L9:
        if (isSystemAuthority == false) goto L15;
        if (systemEntity != null) goto L14;
        Slogf.wtf(TAG, "Error parsing EnforcingAdmin with SystemAuthority, systemEntity is null.");
        return null;
    L14:
        return new EnforcingAdmin(systemEntity);
    L15:
        if (packageName == null) goto L24;
        if (authoritiesStr == null) goto L24;
        String className = parser.getAttributeValue(null, ATTR_CLASS_NAME);
        if (className == null) goto L22;
        componentName = new ComponentName(packageName, className);
    L22:
        Set<String> authorities = Set.of(authoritiesStr.split(ATTR_AUTHORITIES_SEPARATOR));
        return new EnforcingAdmin(packageName, componentName, authorities, userId);
    L24:
        StringBuilder r8 = new StringBuilder();
        r8.append("Error parsing EnforcingAdmin, packageName is ");
        String r9 = "null";
        if (packageName != null) goto L27;
        String r10 = "null";
    L28:
        r8.append(r10);
        r8.append(", and authorities is ");
        if (authoritiesStr == null) goto L32;
        r9 = authoritiesStr;
    L32:
        r8.append(r9);
        r8.append(".");
        Slogf.wtf(TAG, r8.toString());
        return null;
    L27:
        r10 = packageName;
        goto L28
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("EnforcingAdmin { mPackageName= ");
        sb.append(this.mPackageName);
        if (this.mComponentName == null) goto L6;
        sb.append(", mComponentName= ");
        sb.append(this.mComponentName);
    L6:
        if (this.mAuthorities == null) goto L8;
        sb.append(", mAuthorities= ");
        sb.append(this.mAuthorities);
    L8:
        sb.append(", mUserId= ");
        sb.append(this.mUserId);
        sb.append(", mIsRoleAuthority= ");
        sb.append(this.mIsRoleAuthority);
        sb.append(", mIsSystemAuthority= ");
        sb.append(this.mIsSystemAuthority);
        sb.append(", mSystemEntity = ");
        sb.append(this.mSystemEntity);
        sb.append(" }");
        return sb.toString();
    }
}
