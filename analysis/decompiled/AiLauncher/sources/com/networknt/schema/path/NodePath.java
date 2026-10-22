package com.networknt.schema.path;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Objects;

/* loaded from: classes2.dex */
public class NodePath implements Comparable<NodePath>, Path {
    private int hash;
    private final NodePath parent;
    private final String pathSegment;
    private final int pathSegmentIndex;
    private final PathType type;
    private volatile String value;

    public NodePath(PathType pathType) {
        this.value = null;
        this.hash = 0;
        this.type = pathType;
        this.parent = null;
        this.pathSegment = null;
        this.pathSegmentIndex = -1;
    }

    public NodePath append(String str) {
        return new NodePath(this, str);
    }

    public boolean contains(String str) {
        if (str.equals(this.pathSegment)) {
            return true;
        }
        for (NodePath parent = getParent(); parent != null; parent = parent.getParent()) {
            if (str.equals(parent.pathSegment)) {
                return true;
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        NodePath nodePath = (NodePath) obj;
        return Objects.equals(this.pathSegment, nodePath.pathSegment) && this.pathSegmentIndex == nodePath.pathSegmentIndex && this.type == nodePath.type && Objects.equals(this.parent, nodePath.parent);
    }

    public Object getElement(int i10) {
        if (i10 == -1) {
            int i11 = this.pathSegmentIndex;
            return i11 != -1 ? Integer.valueOf(i11) : this.pathSegment;
        }
        int nameCount = getNameCount();
        if (nameCount - 1 == i10) {
            return getElement(-1);
        }
        int i12 = (nameCount - i10) - 1;
        if (i12 < 0) {
            throw new IllegalArgumentException("");
        }
        for (int i13 = 0; i13 < i12; i13++) {
            this = this.parent;
        }
        return this.getElement(-1);
    }

    public String getName(int i10) {
        Object element = getElement(i10);
        if (element != null) {
            return element.toString();
        }
        return null;
    }

    public int getNameCount() {
        int i10 = (this.pathSegmentIndex == -1 && this.pathSegment == null) ? 0 : 1;
        NodePath nodePath = this.parent;
        return i10 + (nodePath != null ? nodePath.getNameCount() : 0);
    }

    public NodePath getParent() {
        return this.parent;
    }

    public PathType getPathType() {
        return this.type;
    }

    public int hashCode() {
        int i10 = this.hash;
        if (i10 != 0) {
            return i10;
        }
        int iHash = Objects.hash(this.parent, this.pathSegment, Integer.valueOf(this.pathSegmentIndex), this.type);
        this.hash = iHash;
        return iHash;
    }

    public boolean startsWith(NodePath nodePath) {
        int nameCount = getNameCount();
        int nameCount2 = nodePath.getNameCount();
        if (nameCount2 > nameCount) {
            return false;
        }
        if (nameCount2 == nameCount) {
            return equals(nodePath);
        }
        for (int i10 = nameCount - nameCount2; i10 > 0; i10--) {
            this = this.getParent();
        }
        return nodePath.equals(this);
    }

    @Override // com.networknt.schema.path.Path
    public String toString() {
        if (this.value == null) {
            if (this.pathSegmentIndex == -1 && this.pathSegment == null) {
                this.value = this.type.getRoot();
                return this.value;
            }
            ArrayDeque arrayDeque = new ArrayDeque();
            int i10 = this.pathSegmentIndex;
            if (i10 != -1) {
                arrayDeque.push(Integer.valueOf(i10));
            } else {
                String str = this.pathSegment;
                if (str != null) {
                    arrayDeque.push(str);
                }
            }
            for (NodePath parent = getParent(); parent != null; parent = parent.getParent()) {
                int i11 = parent.pathSegmentIndex;
                if (i11 != -1) {
                    arrayDeque.push(Integer.valueOf(i11));
                } else {
                    String str2 = parent.pathSegment;
                    if (str2 != null) {
                        arrayDeque.push(str2);
                    }
                }
            }
            StringBuilder sb2 = new StringBuilder();
            String root = this.type.getRoot();
            if (root != null) {
                sb2.append(root);
            }
            Iterator it = arrayDeque.iterator();
            while (it.hasNext()) {
                Object next = it.next();
                if (next instanceof Number) {
                    this.type.append(sb2, ((Number) next).intValue());
                } else {
                    this.type.append(sb2, next.toString());
                }
            }
            this.value = sb2.toString();
        }
        return this.value;
    }

    public NodePath append(int i10) {
        return new NodePath(this, i10);
    }

    @Override // java.lang.Comparable
    public int compareTo(NodePath nodePath) {
        NodePath nodePath2;
        int iCompareTo;
        NodePath nodePath3 = this.parent;
        if (nodePath3 != null && nodePath.parent == null) {
            return 1;
        }
        if (nodePath3 == null && nodePath.parent != null) {
            return -1;
        }
        if (nodePath3 != null && (nodePath2 = nodePath.parent) != null && (iCompareTo = nodePath3.compareTo(nodePath2)) != 0) {
            return iCompareTo;
        }
        String name = getName(-1);
        String name2 = nodePath.getName(-1);
        if (name == null && name2 == null) {
            return 0;
        }
        if (name != null && name2 == null) {
            return 1;
        }
        if (name != null || name2 == null) {
            return name.compareTo(name2);
        }
        return -1;
    }

    private NodePath(NodePath nodePath, String str) {
        this.value = null;
        this.hash = 0;
        this.parent = nodePath;
        this.type = nodePath.type;
        this.pathSegment = str;
        this.pathSegmentIndex = -1;
    }

    private NodePath(NodePath nodePath, int i10) {
        this.value = null;
        this.hash = 0;
        this.parent = nodePath;
        this.type = nodePath.type;
        this.pathSegment = null;
        this.pathSegmentIndex = i10;
    }
}
