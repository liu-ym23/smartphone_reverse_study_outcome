package com.fasterxml.jackson.core;

import java.io.Serializable;
import java.util.Objects;

/* compiled from: r8-map-id-7da402fe3afa8905dc5f5798dd3e7dfb51c589193ca1bab44f52669f99b3ef87 */
/* loaded from: classes.dex */
public class Version implements Comparable<Version>, Serializable {
    private static final Version UNKNOWN_VERSION = new Version(0, 0, 0, null, null, null);
    private static final long serialVersionUID = 1;
    protected final String _artifactId;
    protected final String _groupId;
    protected final int _majorVersion;
    protected final int _minorVersion;
    protected final int _patchLevel;
    protected final String _snapshotInfo;

    public Version(int i, int i3, int i10, String str, String str2, String str3) {
        this._majorVersion = i;
        this._minorVersion = i3;
        this._patchLevel = i10;
        this._snapshotInfo = str;
        this._groupId = str2 == null ? "" : str2;
        this._artifactId = str3 == null ? "" : str3;
    }

    public static Version unknownVersion() {
        return UNKNOWN_VERSION;
    }

    @Override // java.lang.Comparable
    public int compareTo(Version version) {
        if (version == this) {
            return 0;
        }
        int iCompareTo = this._groupId.compareTo(version._groupId);
        if (iCompareTo != 0 || (iCompareTo = this._artifactId.compareTo(version._artifactId)) != 0 || (iCompareTo = this._majorVersion - version._majorVersion) != 0 || (iCompareTo = this._minorVersion - version._minorVersion) != 0 || (iCompareTo = this._patchLevel - version._patchLevel) != 0) {
            return iCompareTo;
        }
        if (!isSnapshot()) {
            return version.isSnapshot() ? 1 : 0;
        }
        if (version.isSnapshot()) {
            return this._snapshotInfo.compareTo(version._snapshotInfo);
        }
        return -1;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Version version = (Version) obj;
        return version._majorVersion == this._majorVersion && version._minorVersion == this._minorVersion && version._patchLevel == this._patchLevel && Objects.equals(version._snapshotInfo, this._snapshotInfo) && version._artifactId.equals(this._artifactId) && version._groupId.equals(this._groupId);
    }

    public String getArtifactId() {
        return this._artifactId;
    }

    public String getGroupId() {
        return this._groupId;
    }

    public int getMajorVersion() {
        return this._majorVersion;
    }

    public int getMinorVersion() {
        return this._minorVersion;
    }

    public int getPatchLevel() {
        return this._patchLevel;
    }

    public int hashCode() {
        return (this._artifactId.hashCode() ^ this._groupId.hashCode()) ^ (((Objects.hashCode(this._snapshotInfo) + this._majorVersion) - this._minorVersion) + this._patchLevel);
    }

    public boolean isSnapshot() {
        String str = this._snapshotInfo;
        return (str == null || str.isEmpty()) ? false : true;
    }

    @Deprecated
    public boolean isUknownVersion() {
        return isUnknownVersion();
    }

    public boolean isUnknownVersion() {
        return this == UNKNOWN_VERSION;
    }

    public String toFullString() {
        return this._groupId + JsonPointer.SEPARATOR + this._artifactId + JsonPointer.SEPARATOR + toString();
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this._majorVersion);
        sb2.append('.');
        sb2.append(this._minorVersion);
        sb2.append('.');
        sb2.append(this._patchLevel);
        if (isSnapshot()) {
            sb2.append('-');
            sb2.append(this._snapshotInfo);
        }
        return sb2.toString();
    }

    @Deprecated
    public Version(int i, int i3, int i10, String str) {
        this(i, i3, i10, str, null, null);
    }
}
