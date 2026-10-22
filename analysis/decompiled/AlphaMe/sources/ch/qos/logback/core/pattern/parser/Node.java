package ch.qos.logback.core.pattern.parser;

/* loaded from: classes.dex */
public class Node {
    static final int COMPOSITE_KEYWORD = 2;
    static final int LITERAL = 0;
    static final int SIMPLE_KEYWORD = 1;
    Node next;
    final int type;
    final Object value;

    public Node(int i4) {
        this(i4, null);
    }

    public boolean equals(Object obj) {
        Object obj2;
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Node)) {
            return false;
        }
        Node node = (Node) obj;
        if (this.type == node.type && ((obj2 = this.value) == null ? node.value == null : obj2.equals(node.value))) {
            Node node2 = this.next;
            if (node2 != null) {
                if (node2.equals(node.next)) {
                    return true;
                }
            } else if (node.next == null) {
                return true;
            }
        }
        return false;
    }

    public Node getNext() {
        return this.next;
    }

    public int getType() {
        return this.type;
    }

    public Object getValue() {
        return this.value;
    }

    public int hashCode() {
        int i4 = this.type * 31;
        Object obj = this.value;
        return i4 + (obj != null ? obj.hashCode() : 0);
    }

    public String printNext() {
        if (this.next == null) {
            return "";
        }
        return " -> " + this.next;
    }

    public void setNext(Node node) {
        this.next = node;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (this.type != 0) {
            sb.append(super.toString());
        } else {
            sb.append("LITERAL(" + this.value + ")");
        }
        sb.append(printNext());
        return sb.toString();
    }

    public Node(int i4, Object obj) {
        this.type = i4;
        this.value = obj;
    }
}
